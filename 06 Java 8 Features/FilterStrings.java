import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class FilterStrings {
	public static void main(String[] args) {
		List<String> names=Arrays.asList("Apple", "Banana", "Avocado", "Mango", "Apricot");
		List<String> filtered=names.stream()
									.filter(name->!name.startsWith("A"))
									.collect(Collectors.toList());
		System.out.println("Filtered list (not starting with A): "+filtered);
	}
}