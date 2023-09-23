import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

  // Константа для определения количества костей.
  private static final int NUMBER_OF_DICE = 2;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Player> players = new ArrayList<>();

    while (true) {
      System.out.print("Введите имя игрока (или оставьте пустым): ");
      String name = scanner.nextLine().trim();

      if (name.isEmpty()) {
        name = "Player " + (players.size() + 1);
      }

      players.add(new Human(name));

      System.out.print("Хотите добавить еще игрока? (y/n): ");
      String input = scanner.nextLine();

      if (!input.equalsIgnoreCase("y")) {
        break;
      }
    }

    // Добавляем компьютера в качестве последнего игрока.
    players.add(new Player("Компьютер"));

    DiceGame game = new DiceGame(players.toArray(new Player[0]), NUMBER_OF_DICE);

    while (game.getWinner() == null) {
      RoundResult result = game.playRound();
      displayRoundResult(result);
      System.out.println(game.getStartingPlayer().getName() + " начинает следующий раунд.");
    }

    System.out.println(game.getWinner().getName() + " выиграл игру!");
  }

  /**
   * Выводит на экран результат раунда.
   *
   * @param result Результат раунда.
   */
  private static void displayRoundResult(RoundResult result) {
    for (Map.Entry<Player, Integer> entry : result.getRolls().entrySet()) {
      System.out.println(entry.getKey().getName() + " выбросил: " + entry.getValue());
    }
    System.out.println(result.getWinner().getName() + " выиграл раунд!");
  }
}
