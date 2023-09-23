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