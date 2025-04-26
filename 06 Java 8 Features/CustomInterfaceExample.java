@FunctionalInterface
interface SquareFunction {
	int square(int x);
	default void showResult(int x) {
		System.out.println("Square of " + x + " is " + square(x));
	}
}
public class CustomInterfaceExample {
	public static void main(String[] args) {
		SquareFunction squareFunc=num->num*num;
		squareFunc.showResult(6);
	}
}