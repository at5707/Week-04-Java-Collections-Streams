import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedWordsExtractor {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        Pattern pattern=Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher matcher=pattern.matcher(text);
        System.out.println("Extracted capitalized words:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}