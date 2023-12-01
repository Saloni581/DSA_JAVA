import java.util.*;
public class CountVowelPermutation {

    public static final int MOD = 1000000007;

    public static int cvp(int n) {
        int dp[][] = new int[n+1][5]; // 5 indicates 5 vowels
        //initialization
        for(int j=0; j<5; j++) {
            dp[1][j] = 1;
        }
        for(int i=2; i<n+1; i++) {
            for(int j=0; j<5; j++) {
                switch (j) {
                    //fixed positions of vowels = a e i o u
                    //                  indeces = [0 1 2 3 4]
                    // 'a' only after 'e' is allowed
                    case 1:
                    dp[i][j] = dp[i-1][1];   
                        break;
                    // 'e' only after 'a' or 'i' is allowed
                    case 2:
                    dp[i][j] = (dp[i-1][0] + dp[i-1][2]) % MOD;   
                        break;
                    // 'i' is not allowed after 'i'
                    case 3:
                    dp[i][j] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][3] + dp[i-1][4]) % MOD;   
                        break;
                    // 'o' only after 'i' or 'u' is allowed
                    case 4:
                    dp[i][j] = (dp[i-1][2] + dp[i-1][4]) % MOD;   
                        break;
                    // 'u' only after 'a' is allowed
                    case 5:
                    dp[i][j] = dp[i-1][0];   
                        break;
                }
            }
        }

        //evaluating dp[][]
         for(int i=0; i<n+1; i++) {
             for(int j=0; j<5; j++) {
                System.out.print(dp[i][j] + " ");
             }
             System.out.println();
         }

        //Sum up all the possible strings of length n
        long ans = 0;
        for(int j=0; j<5; j++) {
           ans = (ans + dp[n][j]) % MOD;
        }
        return (int)ans;
    }
public static void main(String[] args) {
    int n = 1;
    System.out.println(cvp(n));
}
}