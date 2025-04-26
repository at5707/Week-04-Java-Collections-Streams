import java.util.HashSet;
import java.util.Set;

public class SubsetChecker {
    public static <T> boolean isSubset(Set<T> subset,Set<T> superset) {
        return superset.containsAll(subset);
    }
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(Set.of(2, 3));
        Set<Integer> set2=new HashSet<>(Set.of(1, 2, 3, 4));
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        boolean result = isSubset(set1, set2);
        System.out.println("Is Set1 a subset of Set2? " + result);
    }
}