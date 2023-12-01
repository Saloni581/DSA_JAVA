import java.util.*;
// Time Complexity = O(n^2)
public class PrefixSum{
    // prefix[end]-prefix[start-1] 

    public static void maxSubarraySum(int nums[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[nums.length];
        //Calculating prefix sum = prefix[i-1] + prefix[i]
        prefix[0] = nums[0];
        for(int i=1; i<prefix.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        for(int i=0; i<nums.length;i++){
            for(int j=i; j<nums.length; j++){
                //calculating currSum 
                // Here j = end || prefix[end]
                currSum = i == 0 ? prefix[j]: prefix[j] - prefix[i-1]; //prefix[end] - prefix[start-1]
                if(currSum > maxSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max sum = "+ maxSum);
    }
    public static void main(String args[]){
        int arr[] = {1,-2,6,-1,3};
        maxSubarraySum(arr);
          
    }
}

