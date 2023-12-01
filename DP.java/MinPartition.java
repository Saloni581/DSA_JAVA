//Variation of 0-1 Knapsack Problem
import java.util.*;
public class MinPartition {

    public static int minDiffFromPartition(int arr[]) {
        int sum = 0;
        int n = arr.length;
        for(int i=0; i<n; i++) {
            sum += arr[i];
        }
        int W = sum/2; //first knapsack capacity 
        int dp[][] = new int[n+1][W+1];
        //same to same 0-1 knapsack code
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                //valid
                if(arr[i-1] <= j) {
                    //you can include
                    dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);
                }
                //invalid
                else
                dp[i][j] = dp[i-1][j];
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum1-sum2);
    }
    public static void main(String args[]) {
        int arr[] = {1, 6, 11, 5};
        System.out.println(minDiffFromPartition(arr));
    }
}