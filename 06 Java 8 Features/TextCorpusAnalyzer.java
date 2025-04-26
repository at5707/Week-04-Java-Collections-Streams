import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class TextCorpusAnalyzer {
	public static void main(String[] args) {
        String text = "hello world hello java java streams streams streams java lambda lambda world";
        List<String> words = Arrays.asList(text.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+"));

        Map<String, Long> frequencyMap = words.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Top N frequent words
        int N = 3;
        System.out.println("\nTop " + N + " frequent words:");
        frequencyMap.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(N)
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}