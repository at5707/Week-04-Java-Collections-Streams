import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
public class ConsumerExample {
	public static void main(String[] args) {
		List<String> items = Arrays.asList("java", "python", "spring");
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        items.forEach(printUpperCase);
	}
}