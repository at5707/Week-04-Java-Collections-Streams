import java.util.Scanner;

public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        return color.matches("^#([A-Fa-f0-9]{6})$");
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter hex color code to validate: ");
        String color=scanner.nextLine();
        if (isValidHexColor(color)) {
            System.out.println("Valid hex color code");
        } else {
            System.out.println("Invalid hex color code");
        }
        scanner.close();
    }
}