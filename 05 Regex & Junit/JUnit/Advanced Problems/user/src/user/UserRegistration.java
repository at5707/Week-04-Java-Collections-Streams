package user;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistration {

    // Method to register user with basic validation
    public static void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }
    }

    // Inner test class to keep in the same file
    public static class UserRegistrationTest {

        @Test
        public void testValidUserRegistration() {
            try {
                UserRegistration.registerUser("john_doe", "john.doe@example.com", "password123");
            } catch (IllegalArgumentException e) {
                fail("Valid registration should not throw an exception.");
            }
        }

        @Test
        public void testInvalidUsername() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                UserRegistration.registerUser("", "john.doe@example.com", "password123");
            });
            assertEquals("Username cannot be empty.", exception.getMessage());
        }

        @Test
        public void testInvalidEmail() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                UserRegistration.registerUser("john_doe", "invalid-email", "password123");
            });
            assertEquals("Invalid email address.", exception.getMessage());
        }

        @Test
        public void testInvalidPassword() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                UserRegistration.registerUser("john_doe", "john.doe@example.com", "short");
            });
            assertEquals("Password must be at least 8 characters long.", exception.getMessage());
        }
    }
}