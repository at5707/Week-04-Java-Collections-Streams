package temperature;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverter {

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFarenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    public static double farenheitToCelsius(double farenheit) {
        return (farenheit - 32) * 5 / 9;
    }

    // Inner test class to keep in the same file
    public static class TemperatureConverterTest {

        @Test
        public void testCelsiusToFahrenheit() {
            assertEquals(32.0, TemperatureConverter.celsiusToFarenheit(0), 0.001);
            assertEquals(212.0, TemperatureConverter.celsiusToFarenheit(100), 0.001);
            assertEquals(98.6, TemperatureConverter.celsiusToFarenheit(37), 0.001);
        }

        @Test
        public void testFahrenheitToCelsius() {
            assertEquals(0.0, TemperatureConverter.farenheitToCelsius(32), 0.001);
            assertEquals(100.0, TemperatureConverter.farenheitToCelsius(212), 0.001);
            assertEquals(37.0, TemperatureConverter.farenheitToCelsius(98.6), 0.001);
        }
    }
}