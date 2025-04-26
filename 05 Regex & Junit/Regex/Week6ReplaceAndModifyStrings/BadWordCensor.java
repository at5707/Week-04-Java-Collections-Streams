import java.util.Arrays;
import java.util.List;

public class BadWordCensor {
    public static void main(String[] args) {
        String text="This is a damn bad example with some stupid words";
        List<String> badWords=Arrays.asList("damn","stupid");
        for (String word : badWords) {
            text=text.replaceAll("(?i)\\b"+word+"\\b", "****");
        }
        System.out.println("Censored text:");
        System.out.println(text);
    }
}