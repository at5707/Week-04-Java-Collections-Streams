package date;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    // Method to format date from "yyyy-MM-dd" to "dd-MM-yyyy"
    public static String formatDate(String inputDate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            return null;
        }
    }

    // Inner test class to keep in the same file
    public static class DateFormatterTest {

        @Test
        public void testValidDate() {
            assertEquals("12-05-2023", DateFormatter.formatDate("2023-05-12"));
            assertEquals("01-01-2022", DateFormatter.formatDate("2022-01-01"));
            assertEquals("25-12-2020", DateFormatter.formatDate("2020-12-25"));
        }

        @Test
        public void testInvalidDate() {
            assertNull(DateFormatter.formatDate("2023-13-12"));  // Invalid month
            assertNull(DateFormatter.formatDate("2023-05-32"));  // Invalid day
            assertNull(DateFormatter.formatDate("2023-02-29"));  // Non-leap year
            assertNull(DateFormatter.formatDate("20230512"));    // Incorrect format
        }
    }
}