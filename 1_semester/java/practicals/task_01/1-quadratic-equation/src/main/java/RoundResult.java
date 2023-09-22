import java.util.Map;

/**
 * Класс, представляющий результат раунда игры.
 */
public class RoundResult {
  // Победитель раунда
  private Player winner;
  // Результаты бросков всех игроков
  private Map<Player, Integer> rolls;

  public RoundResult(Player winner, Map<Player, Integer> rolls) {
    this.winner = winner;
    this.rolls = rolls;
  }

  /**
   * @return Возвращает победителя раунда.
   */
  public Player getWinner() {
    return winner;
  }

  /**
   * @return Возвращает карту с результатами бросков для всех игроков.
   */
  public Map<Player, Integer> getRolls() {
    return rolls;
  }
}