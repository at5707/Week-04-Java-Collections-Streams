package calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Calculator {
	public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero is not allowed.");
        return a / b;
    }

    public static class CalculatorTest {
        Calculator calc = new Calculator();

        @Test public void testAdd() { assertEquals(10, calc.add(7, 3)); }
        @Test public void testSubtract() { assertEquals(4, calc.subtract(10, 6)); }
        @Test public void testMultiply() { assertEquals(20, calc.multiply(5, 4)); }
        @Test public void testDivide() { assertEquals(2, calc.divide(10, 5)); }
        @Test public void testDivideByZero() {
            Exception e = assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
            assertEquals("Division by zero is not allowed.", e.getMessage());
        }
    }
}
