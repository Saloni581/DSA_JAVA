import java.util.*;

public class KadaneAlgo{
    // Time Complexity = O(n)
    //Normal kadane's Algorithm
    public static void kadaneAlgo(int arr[]){
        int cs = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            cs += arr[i];
            if(cs < 0){
                cs = 0;
            }
          maxSum = Math.max(cs, maxSum);
        }
        System.out.println(maxSum);
    }
       
    //Kadane's algorithm for all negetive values to find minimum and maximum value
    public static void kadaneAlgorithm(int arr[]){
        int minNum = 0;
        int maxNum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < 0){
              if(minNum > arr[i]){
                minNum = arr[i];
              }
              if(maxNum < arr[i]){
                maxNum = arr[i];
              }
            }
        }
        System.out.println("Minimum Number is : "+ minNum);
        System.out.println("Maximum Number is : "+ maxNum);
    }


    public static void main(String args[]){

        //   int nums[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        //  kadaneAlgo(nums);


           int nums[] = {-2, -1, -4, -7};
           kadaneAlgorithm(nums);
           
    }
}

