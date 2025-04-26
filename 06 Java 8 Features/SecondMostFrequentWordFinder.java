import java.util.*;
import java.util.stream.Collectors;
public class SecondMostFrequentWordFinder {
	public static void main(String[] args) {
        String text = "apple banana apple orange banana apple banana banana orange";

        List<String> words = Arrays.asList(text.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+"));

        Map<String, Long> frequencyMap = words.stream()
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        List<Map.Entry<String, Long>> sortedList = frequencyMap.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .collect(Collectors.toList());

        if (sortedList.size() >= 2) {
            System.out.println("Second most frequent word: " + sortedList.get(1).getKey() + " (Count: " + sortedList.get(1).getValue() + ")");
        } else {
            System.out.println("Not enough unique words to find second most frequent.");
        }
    }
}
