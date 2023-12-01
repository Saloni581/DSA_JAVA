import java.util.*;
//fib Code by DP -> TC -> 0(n) from 0(2^n)
public class Basics {

    //By recursion -> TC -> 0(n) 
    //Top Down Approach
    public static int fibMemoization(int n, int dp[]) {
     //Base Case
     if(n == 0 || n == 1) {
        return n;
     }
     if(dp[n] != 0) {
        return dp[n];
     }
     dp[n] = fibMemoization(n-1, dp) + fibMemoization(n-2, dp);
     return dp[n];
    }

    //By Iteration -> TC -> 0(n)
    //Bottom Up Approach
    public static int fibTabulation(int n) {
         int dp[] = new int[n+1];
         dp[1] = 1;
         for(int i=2; i<=n; i++) {
            dp[i] =  dp[i-1] + dp[i-2];
         }
         return dp[n];
    }

    public static void main(String args[]) {
        int n = 1000;
        int dp[] = new int[n+1];
        //System.out.println(fibMemoization(n, dp));
        System.out.println(fibTabulation(n));
    }
}