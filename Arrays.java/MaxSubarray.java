import java.util.*;

public class MaxSubarray{
    public static void main(String args[]){
        int arr[] = {10,20,30,40,50,60,70,80,90,100};
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                currSum = 0;
                for(int k=i; k<=j; k++){
                    currSum += arr[k];
                }
            }
        System.out.println("Current Sum is :"+currSum);
        if(currSum > maxSum){
            maxSum = currSum;
        }
    }
        System.out.println("Maximum Sum is :"+maxSum);
    }
}