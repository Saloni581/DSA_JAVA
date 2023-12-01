import java.util.*;
public class ZeroOneKnapSack {

    //By Recursion -> TC = 0(2^n)
    public static int knapSack(int val[], int wt[], int W, int n) {
        //Base Case
        if(W == 0 || n == 0) {
            return 0;
        }
        //Valid Condition
        if(wt[n-1] <= W) {  
          //Include Choice
          int ans1 = val[n-1]+knapSack(val, wt, W-wt[n-1], n-1);
          //Exclude Choice
          int ans2 = knapSack(val, wt, W, n-1);
          return Math.max(ans1, ans2);
        }

        //Invalid Condition
        else {  //exclude choice
          return knapSack(val, wt, W, n-1);
        }
    }


    //By Memoization -> TC = 0(n*W)
    public static int knapSackMemoization(int val[], int wt[], int W, int n, int dp[][]) {
        //Base Case
        if(W == 0 || n == 0) {
            return 0;
        }
        if(dp[n][W] != -1) {
            return dp[n][W];
        }
        //Valid Condition
        if(wt[n-1] <= W) {  
          //Include Choice
          int ans1 = val[n-1]+knapSackMemoization(val, wt, W-wt[n-1], n-1, dp);
          //Exclude Choice
          int ans2 = knapSackMemoization(val, wt, W, n-1, dp);
          dp[n][W] = Math.max(ans1, ans2);
          return dp[n][W];
        }

        //Invalid Condition
        else {  //exclude choice
          dp[n][W] = knapSack(val, wt, W, n-1);
          return dp[n][W];
        }
    }


    //By  Tabulation -> TC = 0(n*W)
    public static int knapSackTabulation(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        //initialization
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                int v = val[i-1];
                int w = wt[i-1];
                //Valid Condition
                if(w <= j) {   
                   int incProfit = v + dp[i-1][j-w]; //Include 
                   int excProfit = dp[i-1][j];
                   dp[i][j] = Math.max(incProfit, excProfit);
                }
                else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        //printing dp matrix 
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return dp[n][W];
    }

    public static void main(String args[]) {
         int values[] = {15, 14, 10, 45, 30};
         int weight[] = {2, 5, 1, 3, 4};
         int W = 7;

         int dp[][] = new int[values.length+1][W+1];
         for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
         }
        //System.out.println(knapSack(values, weight, W, values.length));
        //System.out.println(knapSackMemoization(values, weight, W, values.length, dp));
        //System.out.println(knapSackTabulation(values, weight, W));
    }
}
