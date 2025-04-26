import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class NthFromEndFinder {
    public static <T> T findNthFromEnd(LinkedList<T> list,int n) {
        if (list==null || n<=0) {
            throw new IllegalArgumentException("Invalid input.");
        }
        ListIterator<T> first=list.listIterator();
        ListIterator<T> second=list.listIterator();
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                throw new IllegalArgumentException("N is larger than the list size.");
            }
            first.next();
        }
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        return second.next();
    }
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>(List.of("A", "B", "C", "D", "E"));
        int n=2;
        System.out.println("Input List: "+list);
        String nthFromEnd=findNthFromEnd(list, n);
        System.out.println("The "+n+"th element from the end is: "+nthFromEnd);
    }
}