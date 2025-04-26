import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class PredicateExample {
	public static void main(String[] args) {
		List<String> words=Arrays.asList("hello", "amazing", "worldwide", "apple", "architect");
		Predicate<String> lengthGreaterThan5=str->str.length()>5;
		Predicate<String> containsWord=str->str.contains("a");
		List<String> filtered=words.stream()
									.filter(lengthGreaterThan5.and(containsWord))
									.collect(Collectors.toList());
		System.out.println("Filtered words: " + filtered);
	}
}