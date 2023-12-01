import java.util.*;

public class Union_InterSection {
    

    public static void main(String args[]) {
           int arr1[] = {7, 3, 9};
           int arr2[] = {6, 3, 9, 2, 9, 4};
           HashSet<Integer> set = new HashSet<>();

           //Union
           for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
           }
           for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
           }
           System.out.println("Union of two set is : "+set.size());
           System.out.println(set);

           //InterSection
          HashSet<Integer> newSet = new HashSet<>();
          for(int i=0; i<arr1.length; i++) {
            newSet.add(arr1[i]);
          }
          int count = 0;
          for(int i=0; i<arr2.length; i++) {
            if(newSet.contains(arr2[i])) {
                count++;
                newSet.remove(arr2[i]);
                System.out.print(newSet);
            }
          }
          System.out.println("InterSection of the arr1 & arr2 is : "+ count);
    }
}
