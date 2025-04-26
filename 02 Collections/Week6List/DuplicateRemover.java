import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListReverser {
    public static <T> void reverseArrayList(ArrayList<T> list) {
        int left=0;
        int right=list.size()-1;
        while (left<right) {
            T temp=list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public static <T> void reverseLinkedList(LinkedList<T> list) {
        int left=0;
        int right=list.size()-1;
        while (left<right) {
            T temp=list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println("Original ArrayList: "+arrayList);
        reverseArrayList(arrayList);
        System.out.println("Reversed ArrayList: "+arrayList);
        LinkedList<Integer> linkedList=new LinkedList<>(List.of(1, 2, 3, 4, 5));
        System.out.println("\nOriginal LinkedList: "+linkedList);
        reverseLinkedList(linkedList);
        System.out.println("Reversed LinkedList: "+linkedList);
    }
}