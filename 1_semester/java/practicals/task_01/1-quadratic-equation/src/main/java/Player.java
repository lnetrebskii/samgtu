import java.util.Random;

/**
 * Класс, представляющий игрока.
 */
public class Player {
  // Имя игрока
  private String name;
  // Общий счет игрока
  private int score;

  /**
   * Конструктор класса Player.
   *
   * @param name Имя игрока.
   */
  public Player(String name) {
    this.name = name;
  }

  /**
   * @return Возвращает имя игрока.
   */
  public String getName() {
    return name;
  }

  /**
   * @return Возвращает текущий счет игрока.
   */
  public int getScore() {
    return score;
  }

  /**
   * Увеличивает счет игрока на одно очко.
   */
  public void incrementScore() {
    this.score++;
  }

  /**
   * Бросает заданное количество кубиков и возвращает общее количество очков.
   *
   * @param numberOfDice Количество кубиков для броска.
   * @return Общая сумма очков с кубиков.
   */
  public int roll(int numberOfDice) {
    Random rand = new Random();
    int roll = 0;
    for (int j = 0; j < numberOfDice; j++) {
      roll += rand.nextInt(6) + 1;
    }
    return roll;
  }
}