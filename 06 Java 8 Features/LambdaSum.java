import java.util.Scanner;
@FunctionalInterface
interface SumFunction {
	int add(int a,int b);
}
public class LambdaSum {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        SumFunction sum=(a,b)->a+b;
        int result=sum.add(num1, num2);
        System.out.println("The sum is: "+result);
        scanner.close();
	}
}
