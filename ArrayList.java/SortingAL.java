import java.util.*;
public class SortingAL {

    public static void main(String args[]){
         ArrayList<Integer> list = new ArrayList<>();
         list.add(2);
         list.add(56);
         list.add(4);
         list.add(9);
         list.add(1);
          
         Collections.sort(list);
         System.out.print(list);
         System.out.println();
         Collections.sort(list, Collections.reverseOrder());
         System.out.print(list);
    }
}
