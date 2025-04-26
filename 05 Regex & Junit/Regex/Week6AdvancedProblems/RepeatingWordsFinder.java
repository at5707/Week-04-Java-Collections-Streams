import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RepeatingWordsFinder {
    public static Set<String> findRepeatingWords(String sentence) {
        sentence=sentence.toLowerCase();
        String[] words=sentence.split("\\s+");
        Map<String,Integer> wordCount=new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
        }
        Set<String> repeatingWords=new HashSet<>();
        for (Map.Entry<String,Integer> entry : wordCount.entrySet()) {
            if (entry.getValue()>1) {
                repeatingWords.add(entry.getKey());
            }
        }
        return repeatingWords;
    }
    public static void main(String[] args) {
        String sentence = "This is is a repeated repeated word test.";
        Set<String> repeatingWords = findRepeatingWords(sentence);
        System.out.println(String.join(", ", repeatingWords));
    }
}