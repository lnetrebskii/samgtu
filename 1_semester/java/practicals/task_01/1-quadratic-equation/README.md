## Project Summary
Разработайте класс для решения квадратных уравнений. Вычисление дискриминанта должен осуществлять вложенный класс. После компиляции объясните структуру class файлов. Проанализируйте использование вложенного класса.
## Screen
![Results](./ResultScreen.png)
## Sources
**https://github.com/lnetrebskii/samgtu/blob/main/1_semester/java/practicals/task_01/1-quadratic-equation/src/main/java/Main.java**
```java
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

  /**
   * Требует ввод числа и при неверно введенном формате требует повторить ввод.
   * @return Введенное число типа float
   */
  private static float promptForFloat(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      try {
        return scanner.nextFloat();
      } catch (InputMismatchException e) {
        System.out.println("Введено некорректное значение. Пожалуйста, введите число.");
        scanner.next(); // Очищаем неверный ввод.
      }
    }

  // После компиляции этого файла будет создан .class файл с именем Main.class.
  }
}
```
**https://github.com/lnetrebskii/samgtu/blob/main/1_semester/java/practicals/task_01/1-quadratic-equation/src/main/java/QuadraticEquation.java**
```java
public class QuadraticEquation {

  private double a, b, c; // Коэффициенты уравнения

  // Конструктор
  /**
   * Конструктор
   * @param a - коэффициент a
   * @param b - коэффициент b
   * @param c - коэффициент c
   */
  public QuadraticEquation(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  /**
   * Вложенный класс для вычисления дискриминанта.
   * 
   * При компиляции этот класс будет скомпилирован в отдельный .class файл с именем 
   * QuadraticEquation$Discriminant.class.
   */
  private class Discriminant {
    private double value;

    /**
     * Вычисляем значения дискриминанта при создании.
     * Вложенный класс имеет доступ к приватным полям внешнего класса, что позволяет 
     * использовать их при вычислении дискриминанта.
     */
    Discriminant() {
      value = b * b - 4 * a * c;
    }

    /**
     * @return Значение дискриминанта.
     */
    public double getValue() {
      return value;
    }
  }

  /**
   * Непосредственно решение уравнения.
   * @return Корни ураванения.
   */
  public double[] solve() {

    if (a == 0) {
      return new double[] { -c / b };
    }

    Discriminant d = new Discriminant();

    // Использование вложенного класса обосновано тем, что дискриминант является 
    // специфичным для квадратного уравнения и не должен использоваться вне контекста этого класса.
    if (d.getValue() > 0) {
      double x1 = (-b + Math.sqrt(d.getValue())) / (2 * a);
      double x2 = (-b - Math.sqrt(d.getValue())) / (2 * a);
      return new double[] { x1, x2 };
    } else if (d.getValue() == 0) {
      double x = -b / (2 * a);
      return new double[] { x };
    } else {
      return new double[] {}; // Комплексные корни
    }
  }
}

// После компиляции этого файла будет создан .class файл с именем QuadraticEquation.class.
```
## Tests
**https://github.com/lnetrebskii/samgtu/blob/main/1_semester/java/practicals/task_01/1-quadratic-equation/src/test/java/QuadraticEquationTest.java**
```java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuadraticEquationTest {

    @Test
    public void testTwoRealRoots() {
        QuadraticEquation equation = new QuadraticEquation(1, -3, 2);
        double[] expected = {2.0, 1.0};
        double[] actual = equation.solve();
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testOneRealRoot() {
        QuadraticEquation equation = new QuadraticEquation(1, 2, 1);
        double[] expected = {-1.0};
        double[] actual = equation.solve();
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testNoRealRoots() {
        QuadraticEquation equation = new QuadraticEquation(1, 0, 1);
        double[] expected = {};
        double[] actual = equation.solve();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCoefficientAIsZero() {
        QuadraticEquation equation = new QuadraticEquation(0, 2, -8);
        double[] expected = {4.0};
        double[] actual = equation.solve();
        assertArrayEquals(expected, actual, 0.00001);
    }
}
```
## Package
Path: 
https://github.com/lnetrebskii/samgtu/blob/main/1_semester/java/practicals/task_01/1-quadratic-equation/quadratic-equation-1.0.jar
### QR Code to the package
![QR Code](QRCode.png)
