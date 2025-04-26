import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        String filePath="input3.txt";
        try {
            HashMap<String,Integer> wordCountMap=countWords(filePath);
            List<Map.Entry<String,Integer>> sortedWords=wordCountMap.entrySet()
                .stream()
                .sorted((entry1,entry2)->entry2.getValue().compareTo(entry1.getValue()))
                .limit(5)
                .collect(Collectors.toList());
            System.out.println("Top 5 most frequent words: ");
            for (Map.Entry<String,Integer> entry : sortedWords) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (Exception e) {
            System.err.println("Error reading the file: "+e.getMessage());
        }
    }
    public static HashMap<String,Integer> countWords(String filePath) throws IOException {
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        try (BufferedReader reader=new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line=reader.readLine())!=null) {
                String[] words=line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0)+1);
                    }
                }
            }
        }
        return wordCountMap;
    }
}