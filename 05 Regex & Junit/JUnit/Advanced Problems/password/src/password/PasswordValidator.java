package password;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidator {

    // Method to validate the password
    public static boolean isValid(String password) {
        if (password.length() < 8) {
            return false; // Password must be at least 8 characters long
        }

        boolean hasUppercase = false;
        boolean hasDigit = false;

        // Check for uppercase letters and digits in the password
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        // Password is valid if it has both an uppercase letter and a digit
        return hasUppercase && hasDigit;
    }

    // Inner test class to keep the test code in the same file
    public static class PasswordValidatorTest {

        @Test
        public void testValidPassword() {
            assertTrue(PasswordValidator.isValid("Password1"));
        }

        @Test
        public void testShortPassword() {
            assertFalse(PasswordValidator.isValid("Pas1"));
        }

        @Test
        public void testNoUppercasePassword() {
            assertFalse(PasswordValidator.isValid("password1"));
        }

        @Test
        public void testNoDigitPassword() {
            assertFalse(PasswordValidator.isValid("Password"));
        }

        @Test
        public void testAllValidConditions() {
            assertTrue(PasswordValidator.isValid("StrongPass9"));
        }
    }
}