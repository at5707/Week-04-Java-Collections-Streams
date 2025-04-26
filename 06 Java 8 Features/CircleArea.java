import java.util.function.Function;
public class CircleArea {
	public static void main(String[] args) {
		Function<Double,Double> area=radius->Math.PI*radius*radius;
		double result=area.apply(5.0);
		System.out.println("Area of circle: "+result);
	}
}