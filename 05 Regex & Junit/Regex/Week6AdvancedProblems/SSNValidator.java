import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SSNValidator {
    public static boolean isValidSSN(String ssn) {
        String regex="^(?!000|666|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0{4})\\d{4}$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(ssn);
        return matcher.matches();
    }
    public static void main(String[] args) {
        String input1 = "My SSN is 123-45-6789.";
        String input2 = "123456789";
        String ssn1 = input1.replaceAll("[^0-9-]", "");
        String ssn2 = input2.replaceAll("[^0-9-]", "");
        if (isValidSSN(ssn1)) {
            System.out.println("\""+ssn1+"\"is valid");
        } else {
            System.out.println("\""+ssn1+"\"is invalid");
        }
        if (isValidSSN(ssn2)) {
            System.out.println("\""+ssn2+"\"is valid");
        } else {
            System.out.println("\""+ssn2+"\"is invalid");
        }
    }
}