import java.util.HashMap;
import java.util.Map;

/**
 * Класс, представляющий игру в кости.
 */
public class DiceGame {

  // Константа для определения необходимого количества победных раундов, чтобы
  // считать игру завершенной.
  private static final int NUMBER_WINNED_ROUNDS_TO_WIN = 7;

  // Массив всех игроков
  private Player[] players;
  // Количество кубиков для броска
  private int K;
  // Игрок, начинающий раунд
  private Player startingPlayer;

  public DiceGame(Player[] players, int K) {
    this.players = players;
    this.K = K;
    this.startingPlayer = players[0];
  }

  /**
   * @return Возвращает игрока, начинающего раунд.
   */
  public Player getStartingPlayer() {
    return startingPlayer;
  }

  /**
   * Производит раунд игры и возвращает результат.
   *
   * @return Результат раунда.
   */
  public RoundResult playRound() {
    Player roundWinner = startingPlayer;
    int maxRoll = 0;
    Map<Player, Integer> rolls = new HashMap<>();

    for (Player player : players) {
      int currentRoll = player.roll(K);
      rolls.put(player, currentRoll);
      if (currentRoll > maxRoll) {
        maxRoll = currentRoll;
        roundWinner = player;
      }
    }

    roundWinner.incrementScore();
    startingPlayer = roundWinner;

    return new RoundResult(roundWinner, rolls);
  }

  /**
   * @return Возвращает победителя игры или null, если игра еще не завершена.
   */
  public Player getWinner() {
    for (Player player : players) {
      if (player.getScore() == NUMBER_WINNED_ROUNDS_TO_WIN) {
        return player;
      }
    }
    return null;
  }
}