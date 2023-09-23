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
