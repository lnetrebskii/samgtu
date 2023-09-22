function GenerateQRCode {
    param (
        [string]$data,
        [string]$outputFile
    )

    $url = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=$data"
    Invoke-WebRequest $url -OutFile $outputFile
}

function BuildJavaProject {
    param (
        [string]$dirPath
    )

    Set-Location $dirPath

    # Build the Java project using Maven
    Write-Host "Building Java project in $dirPath..."
    $mvnResult = & mvn clean package

    # Check if build was successful
    if ($LASTEXITCODE -ne 0) {
        Write-Host "Failed to build project in $dirPath"
        return
    }

    # Move the generated .jar (binary) to the project root
    $targetPath = "$dirPath\target"
    $destPath = ""
    $jarFile = Get-ChildItem -Path $targetPath -Filter "*.jar" | Select-Object -First 1
    if ($jarFile) {
        $destPath = "$dirPath\$($jarFile.Name)"
        Move-Item -Path $jarFile.FullName -Destination $destPath -Force
        Write-Host "Moved binary to $destPath"
    } else {
        Write-Host "No .jar file found for project in $dirPath"
    }

    return $destPath
}

function GenerateReadmeInDir {
    param (
        [string]$dirPath
    )

    Set-Location $dirPath

    # Get the URL of the remote git repository
    $gitRemoteUrl = $(git ls-remote --get-url origin)

    # Get the root directory of the git repository
    $gitRoot = $(git rev-parse --show-toplevel) -replace '/', '\'

    # Create or overwrite README.md
    [xml]$pom = Get-Content ".\pom.xml" -Encoding UTF8
    $description = $pom.project.description.Trim()
    echo "## Project Summary" > README.md
    echo $description >> README.md

    # Insert screenshot
    echo "## Screen" >> README.md
    echo "![Results](./ResultScreen.png)" >> README.md

    function AddJavaContentToReadme {
        param (
            [string]$path,
            [string]$header
        )
        Write-Host "Processing files from $header..."
        Get-ChildItem -Path $path -Recurse -Filter *.java | ForEach-Object {
            $relativePath = $_.FullName.Replace($gitRoot, '').TrimStart('\')
            $githubPath = "$gitRemoteUrl/blob/main/$relativePath".Replace('\', '/')
            echo "### $githubPath" >> README.md
            echo '```java' >> README.md
            Get-Content $_.FullName -Encoding UTF8 | Out-File -Append README.md
            echo '```' >> README.md
        }
    }

    echo "## Sources" >> README.md
    # Add content of each Java file in src/main/java to README.md
    AddJavaContentToReadme ".\src\main\java" "source files from src/main/java"

    echo "## Tests" >> README.md
    # Add content of each Java test file in src/test/java to README.md
    AddJavaContentToReadme ".\src\test\java" "test files from src/test/java"

    Write-Host "README.md generated successfully in $dirPath!"

    # Build the Java project
    $destPath = BuildJavaProject -dirPath $dirPath
    $relativePath = $destPath.Replace($gitRoot, '').TrimStart('\')
    $githubPath = "$gitRemoteUrl/blob/main/$relativePath".Replace('\', '/')

    # Create a QR code for the project path
    $qrCodePath = "QRCode.png"
    GenerateQRCode -data $githubPath -outputFile $qrCodePath

    echo "## Package" >> README.md
    echo "Path: " $githubPath >> README.md
    echo "### QR Code to the package" >> README.md
    echo "![QR Code]($qrCodePath)" >> README.md

    Set-Location $script:initialDir
}

$initialDir = Get-Location
Get-ChildItem -Path $initialDir -Recurse -File -Filter "pom.xml" | ForEach-Object {
    GenerateReadmeInDir $_.DirectoryName
}
