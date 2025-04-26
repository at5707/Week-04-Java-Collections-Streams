import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtractor {
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        Pattern pattern=Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
        Matcher matcher=pattern.matcher(text);
        List<String> dates=new ArrayList<>();
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        System.err.println("Extracted dates:");
        System.out.println(String.join(", ",dates));
    }
}