import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

class RoundResultTest {
  private RoundResult roundResult;
  private Player player1;
  private Player player2;
  private Map<Player, Integer> rolls;

  @BeforeEach
  void setUp() {
    player1 = new Player("Player1");
    player2 = new Player("Player2");
    rolls = new HashMap<>();
    rolls.put(player1, 5);
    rolls.put(player2, 3);
    roundResult = new RoundResult(player1, rolls);
  }

  @Test
  void getWinner() {
    assertEquals(player1, roundResult.getWinner());
  }

  @Test
  void getRolls() {
    assertEquals(rolls, roundResult.getRolls());
  }
}
