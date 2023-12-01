import java.util.*;
public class RodCutting {
    
    public static int rodCutting(int length[], int prices[], int totRodLen) {
        int n = prices.length;  //or I can take length.length also as length is the same for both of the arrays
        int dp[][] = new int[n+1][totRodLen+1];
        //initialization -> as java initialize array elms val already with 0 yet we need to clear the initialization 
        //in our mind (Even though we do not need to do this) 
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<totRodLen+1; j++) {
                if(i == 0 || j == 0) {
                   dp[i][j] = 0; 
                }
            }
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<totRodLen+1; j++) {
                //valid
                if(length[i-1] <= j) {
                    //unbounded knapsack code 
                   dp[i][j] = Math.max(prices[i-1] + dp[i][j - length[i-1]], dp[i-1][j]);
                }
                else //invalid - totally Exclude
                dp[i][j] = dp[i-1][j];
            }
        }
        //printing dp[][]
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][totRodLen];
    }
    public static void main(String args[]) {
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int prices[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;
        System.out.println(rodCutting(length, prices, rodLength));
    }
}
