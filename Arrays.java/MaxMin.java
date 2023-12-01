import java.util.*;

public class MaxMin{

    public static void main(String args[]){
           //largest Number Code 

           int arr[] = {23,45,56,8,990};
           int max = Integer.MIN_VALUE;
           for(int i=0; i<arr.length; i++){
            if(max < arr[i]){
               max = arr[i];
            }
           }
           System.out.println("Maximum value is : "+max);

           //Smallest Number Code

           int min = Integer.MAX_VALUE;
           for(int i=0; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
           }
           System.out.println("Minimum value is : "+min);

    }
}