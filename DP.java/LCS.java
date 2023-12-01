import java.util.*;

public class LCS {

    //By Simple recursion 
    public static int lcs(String s1, String s2, int n, int m) {
        //Base Case
        if(n == 0 || m == 0) {
            return 0;
        }
        //Same 
        if(s1.charAt(n-1) == s2.charAt(m-1)) {
            //+1 is for the current same ans
           return lcs(s1, s2, n-1, m-1) + 1;
        }
        else {
            int ans1 = lcs(s1, s2, n-1, m);
            int ans2 = lcs(s1, s2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }

    
    //By DP or Memoization 
    public static int lcsDP(String str1, String str2, int n, int m) {
        //Base Case
        if(n == 0 || m == 0) {
            return 0;
        }
        //Creating dp[][] to store overlapping subproblems
        int dp[][] = new int[n+1][m+1];
        //initialization
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++) {
                dp[i][j] = -1;
            }
        }
        //Check if solution is already calculated or not in dp[][]
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            //storing dp ans before returning it
            return dp[n][m] = lcsDP(str1, str2, n-1, m-1)+1;
        }
        else {
            int ans1 = lcsDP(str1, str2, n-1, m);
            int ans2 = lcsDP(str1, str2, n, m-1);
            //Storing dp ans before returning it
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }


    //By Tabulation
    public static int lcs(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
    
    public static void main(String args[]) { 
        String str1 = "abcdefg";
        String str2 = "abeg";
        //System.out.println(lcs(str1, str2, str1.length(), str2.length()));
        System.out.println(lcsDP(str1, str2, str1.length(), str2.length()));
    }
}