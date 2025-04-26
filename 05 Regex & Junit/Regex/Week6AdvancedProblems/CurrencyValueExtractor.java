import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyValueExtractor {
    public static List<String> extractCurrencyValues(String text) {
        String regex="(\\$?\\d+(?:\\.\\d{1,2})?)";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);
        List<String> currencyValues=new ArrayList<>();
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        return currencyValues;
    }
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> currencies=extractCurrencyValues(text);
        System.out.println(String.join(", ", currencies));
    }
}