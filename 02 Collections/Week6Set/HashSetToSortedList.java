import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetToSortedList {
    public static List<Integer> convertAndSort(Set<Integer> set) {
        List<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
    public static void main(String[] args) {
        Set<Integer> hashSet=new HashSet<>(Set.of(5, 3, 9, 1));
        System.out.println("HashSet: "+hashSet);
        List<Integer> sortedList=convertAndSort(hashSet);
        System.out.println("Sorted List: "+sortedList);
    }
}