import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DiceGameTest {

  @Test
  void playerWhoWinsSevenTimesShouldBeWinner() {
    
    Player player = new Player("Test");
    DiceGame game = new DiceGame(new Player[] { player }, 1);

    for (int i = 0; i < 7; i++) {
      game.playRound();
    }

    assertEquals(player, game.getWinner(), "Player who won 7 rounds should be the game winner.");
  }
}