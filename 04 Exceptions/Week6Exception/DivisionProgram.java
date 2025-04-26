import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionProgram {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        try {
            System.out.println("Enter the numerator: ");
            double numerator=scanner.nextDouble();
            System.out.println("Enter the denominator: ");
            double denominator=scanner.nextDouble();
            if (denominator == 0) {
                System.out.println("Error: Division by zero is not allowed.");
            } else {
                double result = numerator / denominator;
                System.out.println("The result of the division is: " + result);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid numeric values");
        } finally {
            scanner.close();
        }
    }
}