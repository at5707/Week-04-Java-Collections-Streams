import java.util.Scanner;

public class SpaceNormalizer {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a sentence with multiple spaces:");
        String input=scanner.nextLine();
        String result=input.replaceAll("\\s{2,}", " ");
        System.out.println("Normalized sentence:");
        System.out.println(result);
        scanner.close();
    }
}