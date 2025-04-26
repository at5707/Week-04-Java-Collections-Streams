import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressValidator {
    public static boolean isValidIP(String ip) {
        String regex="^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(ip);
        if (matcher.matches()) {
            for (int i = 1; i <= 4; i++) {
                int part=Integer.parseInt(matcher.group(i));
                if (part<0||part>255) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isValidIP("192.168.1.1"));  
        System.out.println(isValidIP("256.256.256.256"));  
        System.out.println(isValidIP("192.168.1.256"));  
        System.out.println(isValidIP("192.168.1"));  
    }
}