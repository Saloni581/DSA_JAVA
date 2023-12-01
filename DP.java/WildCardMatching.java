public class WildCardMatching {

    public static boolean isMatching(String str, String patt) {
        int n = str.length();
        int m = patt.length();
        //create 2d array
        boolean dp[][] = new boolean[n+1][m+1];
        //initialization
        dp[0][0] = true;
        //pattern = " " and string has some characters in it
        for(int i=1; i<n+1; i++) {
            dp[i][0] = false;
        }
        //str = " " and pattern has some pattern in it
        for(int j=1; j<m+1; j++) {
            //checking if prev char was a star if it was = true for now then check for j-1th length of string 
            if(patt.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1]; //for rest of the string 
            }
        }
        //bottom - up code
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                //Case 1 : 
                if(str.charAt(i-1) == patt.charAt(j-1) || patt.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(patt.charAt(i-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String args[]) {
          String s = "saloni";
          String pattern = "****n?";
          System.out.println(isMatching(s, pattern));
    }
}
  