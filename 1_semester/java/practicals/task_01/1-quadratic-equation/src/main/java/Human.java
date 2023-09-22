import java.util.Scanner;

/**
 * Класс, представляющий человека-игрока.
 */
class Human extends Player {
  // Сканер для ввода данных
  private Scanner scanner = new Scanner(System.in);

  public Human(String name) {
    super(name);
  }

  /**
   * Просит игрока нажать 'k' для броска кубиков и возвращает результат.
   *
   * @param numberOfDice Количество кубиков для броска.
   * @return Общая сумма очков с кубиков.
   */
  @Override
  public int roll(int numberOfDice) {
    String input = "";
    while (!input.equals("k")) {
      System.out.printf("%s, введите 'k' чтобы бросить кости.\n", super.getName());
      input = scanner.nextLine();
    }

    return super.roll(numberOfDice);
  }
}