import java.util.*;

public class UnboundedKnapSack {

    public static int unboundedKnapSack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                //valid
                int curr = wt[i-1];
                if(curr <= j) {             
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-curr], dp[i-1][j]);
                }
                //invalid + Exclude
                else {
                  dp[i][j] = dp[i-1][j];
                }
            }
        }
        //printing dp[][]
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][W];
    }
    
    public static void main(String args[]) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7; 
        System.out.println(unboundedKnapSack(val, wt, W));
    }
}
