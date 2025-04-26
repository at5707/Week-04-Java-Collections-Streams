import java.util.HashSet;
import java.util.Set;

public class SetComparator {
    public static <T> boolean areSetsEqual(Set<T> set1,Set<T> set2) {
        if (set1==null || set2==null) {
            return false;
        }
        return set1.equals(set2);
    }
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2=new HashSet<>(Set.of(3, 2, 1));
        System.out.println("Set1: "+set1);
        System.out.println("Set2: "+set2);
        boolean isEqual=areSetsEqual(set1, set2);
        System.out.println("Are both sets equal? "+isEqual);
    }
}