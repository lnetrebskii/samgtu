import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    float a = promptForFloat(scanner, "Коэффициент a = ");
    float b = promptForFloat(scanner, "Коэффициент b = ");
    float c = promptForFloat(scanner, "Коэффициент c = ");

    QuadraticEquation equation = new QuadraticEquation(a, b, c);
    double[] roots = equation.solve();

    for (double root : roots) {
      System.out.println("Корень: " + root);
    }

  }

  private static float promptForFloat(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      try {
        return scanner.nextFloat();
      } catch (InputMismatchException e) {
        System.out.println("Введено некорректное значение. Пожалуйста, введите число.");
        scanner.next(); // Clear the invalid input
      }
    }
  }
}