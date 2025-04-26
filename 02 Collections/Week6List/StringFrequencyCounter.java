import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringFrequencyCounter {
    public static Map<String,Integer> countFrequency(List<String> list) {
        Map<String,Integer> frequencyMap=new HashMap<>();
        for (String item : list) {
            if (frequencyMap.containsKey(item)) {
                frequencyMap.put(item, frequencyMap.get(item)+1);
            } else {
                frequencyMap.put(item, 1);
            }
        }
        return frequencyMap;
    }
    public static void main(String[] args) {
        List<String> inputList=new ArrayList<>(List.of("apple", "banana", "apple", "orange"));
        System.out.println("Input List: "+inputList);
        Map<String,Integer> frequency=countFrequency(inputList);
        System.out.println("Frequency Map: "+frequency);
    }
}