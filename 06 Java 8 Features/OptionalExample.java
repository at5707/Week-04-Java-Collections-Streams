import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class OptionalExample {
	public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList();

        Optional<Integer> max = numbers.stream().max(Integer::compareTo);

        if (max.isPresent()) {
            System.out.println("Maximum value: " + max.get());
        } else {
            System.out.println("List is empty. No maximum value found.");
        }
    }
}
