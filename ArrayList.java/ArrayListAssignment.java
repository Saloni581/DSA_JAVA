import java.util.*;
public class ArrayListAssignment {
      
    //practice question 1
    public static boolean isMonotonic(ArrayList<Integer> mono){
           boolean inc = true;
           boolean dec = true;

           for(int i=0; i<mono.size()-1; i++){
              if(mono.get(i) > mono.get(i+1))
              inc = false;
              if(mono.get(i) < mono.get(i+1))
              dec = false;

           }
           return inc || dec;
}


//practice question 2
public static boolean isLonely(ArrayList<Integer> nums){
       for(int x=0; x<nums.size(); x++){
        if(nums.get(x) < nums.get(x+1))
        if(x < x+1){
            return true;
        }
       }
       return false;
}
    public static void main(String args[]){
           ArrayList<Integer> mono = new ArrayList<>();

           mono.add(1);
           mono.add(8);
           mono.add(3);

          System.out.println(isMonotonic(mono));
    }
}
