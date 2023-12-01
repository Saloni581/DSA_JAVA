import java.util.*;
public class SwapValues {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
    public static void main(String args[]){
           ArrayList<Integer> list = new ArrayList<>();
           list.add(5);
           list.add(10);
           list.add(15);
           list.add(20);
           list.add(7);
           list.add(9);
           list.add(19);
           System.out.print(list);
           System.out.println();
           swap(list, 3, 6);
           System.out.print(list);
    }
}
