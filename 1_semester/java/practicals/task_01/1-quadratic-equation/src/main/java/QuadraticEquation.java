public class QuadraticEquation {

  private double a, b, c; // Коэффициенты уравнения

  // Конструктор
  public QuadraticEquation(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  // Вложенный класс для вычисления дискриминанта
  private class Discriminant {
    private double value;

    Discriminant() {
      value = b * b - 4 * a * c;
    }

    public double getValue() {
      return value;
    }
  }

  public double[] solve() {
    Discriminant d = new Discriminant();

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
