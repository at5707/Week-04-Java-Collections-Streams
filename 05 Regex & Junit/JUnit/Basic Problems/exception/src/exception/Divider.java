package exception;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class Divider {
	public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    // 🧪 Nested Test Class
    public static class DividerTest {

        Divider divider = new Divider();

        @Test
        public void testDivideNormal() {
            assertEquals(4, divider.divide(8, 2));  // Normal division case
        }

        @Test
        public void testDivideByZero() {
            ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
                divider.divide(8, 0);  // Should throw exception
            });
            assertEquals("Division by zero is not allowed.", exception.getMessage());
        }
    }
}
