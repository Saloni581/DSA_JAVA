
import java.util.*;

public class Basics{
    public static void main(String args[]){
          ArrayList<Integer> list = new ArrayList<>();
          list.add(1);
          list.add(2);
          list.add(3);
          list.add(4);
          list.add(5);
          list.add(6);
        //   System.out.print(list);
        //   System.out.println();
        //   for(int i=0; i<list.size(); i++){
        //     System.out.print(list.get(i)+" ");
        //   }
        //   System.out.println();

        //Reversing an ArrayList
        //   for(int i=list.size()-1; i>=0; i--){
        //     System.out.print(list.get(i)+" ");
        //   }
        //   System.out.println();

        //Max in ArrayList
        int max = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        System.out.println(max);
    }
}