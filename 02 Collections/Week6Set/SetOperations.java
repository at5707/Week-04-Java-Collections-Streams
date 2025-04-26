import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static <T> Set<T> union(Set<T> set1,Set<T> set2) {
        Set<T> result=new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
    public static <T> Set<T> intersection(Set<T> set1,Set<T> set2) {
        Set<T> result=new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2=new HashSet<>(Set.of(3, 4, 5));
        System.out.println("Set1: "+set1);
        System.out.println("Set2: "+set2);
        Set<Integer> unionSet=union(set1, set2);
        Set<Integer> intersectionSet=intersection(set1, set2);
        System.out.println("Union: "+unionSet);
        System.out.println("Intersection: "+intersectionSet);
    }
}