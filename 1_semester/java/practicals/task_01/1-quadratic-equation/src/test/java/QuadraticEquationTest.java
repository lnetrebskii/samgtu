import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuadraticEquationTest {

    @Test
    public void testTwoRealRoots() {
        QuadraticEquation equation = new QuadraticEquation(1, -3, 2);
        double[] expected = {2.0, 1.0};
        double[] actual = equation.solve();
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testOneRealRoot() {
        QuadraticEquation equation = new QuadraticEquation(1, 2, 1);
        double[] expected = {-1.0};
        double[] actual = equation.solve();
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testNoRealRoots() {
        QuadraticEquation equation = new QuadraticEquation(1, 0, 1);
        double[] expected = {};
        double[] actual = equation.solve();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCoefficientAIsZero() {
        QuadraticEquation equation = new QuadraticEquation(0, 2, -8);
        double[] expected = {4.0};
        double[] actual = equation.solve();
        assertArrayEquals(expected, actual, 0.00001);
    }
}
