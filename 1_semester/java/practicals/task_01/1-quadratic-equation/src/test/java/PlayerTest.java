import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
  private Player player;

  @BeforeEach
  void setUp() {
    player = new Player("TestPlayer");
  }

  @Test
  void incrementScore() {
    player.incrementScore();
    assertEquals(1, player.getScore());
  }

  @Test
  void roll() {
    int result = player.roll(2); // бросаем 2 кубика
    assertTrue(result >= 2 && result <= 12); // сумма очков должна быть между 2 и 12 включительно
  }
}