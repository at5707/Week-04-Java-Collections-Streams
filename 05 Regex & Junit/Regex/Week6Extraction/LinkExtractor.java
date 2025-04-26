import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        Pattern pattern=Pattern.compile("https?://\\S+");
        Matcher matcher=pattern.matcher(text);
        List<String> links=new ArrayList<>();
        while (matcher.find()) {
            links.add(matcher.group());
        }
        System.out.println("Extracted links:");
        System.out.println(String.join(", ", links));
    }
}