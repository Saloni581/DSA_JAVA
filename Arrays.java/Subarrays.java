
//TIME COMPLEXITY = O(N^3)
import java.util.*;
// NO. of total subarrays = n(n+1)/2
// NO. of total pairs = n(n-1)/2
public class Subarrays{
    public static void main(String args[]){

        int arr[] = {10,20,30,40,50,60,70,80,90,100};
        int count = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                for(int k=i; k<=j; k++){
                    System.out.print(arr[k]+" ");
                }
                 count++;
                System.out.println();
            }
        }
        System.out.println("Total Subarrays are : "+count);
    }
}