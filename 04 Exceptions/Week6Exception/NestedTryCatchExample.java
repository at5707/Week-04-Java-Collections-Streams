import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr={10,20,30,40,50};
        try {
            System.out.print("Enter index to access: ");
            int index=scanner.nextInt();
            try {
                int value=arr[index];
                System.out.print("Enter divisor: ");
                int divisor=scanner.nextInt();
                try {
                    int result=value/divisor;
                    System.out.println("Result: "+result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index");
            }
       } finally {
            scanner.close();
        }
    }
}