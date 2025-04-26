import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        try {
            System.out.print("Enter the size of the array: ");
            int size=scanner.nextInt();
            int[] arr=new int[size];
            System.out.println("Enter "+size+" elements of the array:");
            for (int i = 0; i < size; i++) {
                arr[i]=scanner.nextInt();
            }
            System.out.println("Enter the index to retrieve: ");
            int index=scanner.nextInt();
            if (arr==null) {
                System.out.println("Array is not initialized!");
            } else {
                System.out.println("Value at index "+index+": "+arr[index]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred");
        } finally {
            scanner.close();
        }
    }
}