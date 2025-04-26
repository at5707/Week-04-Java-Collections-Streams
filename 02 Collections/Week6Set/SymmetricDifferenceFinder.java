import java.util.HashSet;
import java.util.Set;

public class SymmetricDifferenceFinder {
    public static <T> Set<T> symmetricDifference(Set<T> set1,Set<T> set2) {
        Set<T> result=new HashSet<>(set1);
        Set<T> temp=new HashSet<>(set2);
        result.removeAll(set2);
        temp.removeAll(set1);
        result.addAll(temp);
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2=new HashSet<>(Set.of(3, 4, 5));
        System.out.println("Set1: "+set1);
        System.out.println("Set2: "+set2);
        Set<Integer> symDiff=symmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: "+symDiff);
    }
}