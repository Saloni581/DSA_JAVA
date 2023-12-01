import java.util.*;
public class CatalanNumber {

    //using simple recursion
    public static int findCatalan(int n) {
        if(n == 1 || n == 0) {
            return 1;
        }
        int Cn = 0;
        for(int i=0; i<n; i++) {
           Cn += findCatalan(i) * findCatalan(n-i-1);
        }
        return Cn;
    }


    //using memoization = TC = Exponential
    public static int findCatalanM(int n, int dp[]) {
        //Base Case
        if(n == 1 || n == 0) { 
          return 1;
        }
        Arrays.fill(dp, -1);
        if(dp[n] != -1) {
          return dp[n];
        }
        int Cn = 0;
        for(int i=0; i<n; i++) {
            Cn += findCatalanM(i, dp) * findCatalanM(n-i-1, dp);
        }
         
        return dp[n] = Cn;
    }



    //using tabulation = TC = 0(n^2)
    public static int catalanTab(int n) {
        int dp[] = new int[n+1];
        //initialization
        dp[0] = 1;
        dp[1] = 1;
        //bottom - up filling
        for(int i=2; i<n+1; i++) {
            //calculating catalan for each i
            for(int j=0; j<i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int dp[] = new int[n+1];
        //System.out.println(findCatalan(n));
        //System.out.println(findCatalanM(n, dp));
        System.out.println(catalanTab(n));
    }
}