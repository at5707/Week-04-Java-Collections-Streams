import java.util.ArrayList;
import java.util.List;

public class ListRotator {
    public static <T> void rotateList(ArrayList<T> list,int positions) {
        int n=list.size();
        if (n==0 || positions % n==0) {
            return;
        }
        positions=positions%n;
        ArrayList<T> temp=new ArrayList<>();
        for (int i = positions; i < n; i++) {
            temp.add(list.get(i));
        }
        for (int i = 0; i < positions; i++) {
            temp.add(list.get(i));
        }
        for (int i = 0; i < n; i++) {
            list.set(i, temp.get(i));
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>(List.of(10, 20, 30, 40, 50));
        int rotateBy=2;
        System.out.println("Original List: "+list);
        rotateList(list, rotateBy);
        System.out.println("Rotated List: "+list);
    }
}