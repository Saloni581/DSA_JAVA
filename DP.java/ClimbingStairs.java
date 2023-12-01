import java.util.*;

public class ClimbingStairs {

    //Simple recursion -> 0(2^n)
    public static int climbingWays(int n) {
        //Base Case
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 0;
        }
        return climbingWays(n-1)  + climbingWays(n-2);
    }

    //Recursion + dp -> Memoization -> 0(n)
    public static int climbingWaysMemoization(int n, int dp[]) { 
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 0;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        dp[n] = climbingWaysMemoization(n-1, dp) + climbingWaysMemoization(n-2, dp);
        return dp[n];
    }

    //Recusion + dp -> Tabulation -> 0(n)
    public static int climbingWaysTabulation(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;

        if(dp[n] != 0) {
            return dp[n];
        }
        for(int i=1; i<=n; i++) {
           if(i == 1) {
              dp[i] = dp[i-1] + 0;
           }
           else {
            dp[i] = dp[i-1] + dp[i-2];
           }
        }
        return dp[n];
    }
    public static void main(String args[]) {
          int n = 10000;
          //System.out.println(climbingWays(n));
          int dp[] = new int[n+1];
          Arrays.fill(dp, -1);
          //System.out.println(climbingWaysMemoization(n, dp));
          System.out.println(climbingWaysTabulation(1000));
    }
}
