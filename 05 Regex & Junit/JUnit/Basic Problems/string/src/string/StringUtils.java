package string;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class StringUtils {
	public String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        if (str == null) return false;
        String reversed = reverse(str);
        return str.equals(reversed);
    }

    public String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }

    // Inner test class to keep in the same file
    public static class StringUtilsTest {
        StringUtils utils = new StringUtils();

        @Test
        public void testReverse() {
            assertEquals("cba", utils.reverse("abc"));
            assertEquals("racecar", utils.reverse("racecar"));
            assertNull(utils.reverse(null));
        }

        @Test
        public void testIsPalindrome() {
            assertTrue(utils.isPalindrome("racecar"));
            assertTrue(utils.isPalindrome("madam"));
            assertFalse(utils.isPalindrome("hello"));
            assertFalse(utils.isPalindrome(null));
        }

        @Test
        public void testToUpperCase() {
            assertEquals("HELLO", utils.toUpperCase("hello"));
            assertEquals("JAVA", utils.toUpperCase("Java"));
            assertNull(utils.toUpperCase(null));
        }
    }
}
