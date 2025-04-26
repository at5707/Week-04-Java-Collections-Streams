import java.util.Scanner;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        if (username.length()<5||username.length()>15) {
            return false;
        }
        if (!Character.isLetter(username.charAt(0))) {
            return false;
        }
        return username.matches("[a-zA-Z0-9_]+");
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a username to validate: ");
        String username=scanner.nextLine();
        if (isValidUsername(username)) {
            System.out.println("Valid username");
        } else {
            System.out.println("Invalid username");
        }
        scanner.close();
    }
}
