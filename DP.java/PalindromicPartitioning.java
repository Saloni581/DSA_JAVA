public class PalindromicPartitioning {


 public static int palindromicPartition(String str)
    {
        // code here
    int n = str.length();
    
    // minCuts[i] stores the minimum number of cuts needed for
    // substring str[0..i]
    int minCuts[] = new int[n];
    
    // isPalindrome[i][j] stores true if substring str[i..j] is palindrome
    boolean dp[][] = new boolean[n][n];
    
    // Fill the dp table in bottom up manner
    for (int i = 0; i < n; i++)
    {
        dp[i][i] = true;
    }
    
    for (int L = 2; L <= n; L++)
    {
        // For substring of length L, set different possible starting indexes
        for (int i = 0; i < n - L + 1; i++)
        {
            int j = i + L - 1; // Set ending index 1=> 1 2 3 4 5 && 
            //2=> 1 2 3 4 && 3=> 1 2 3 && 4=> 1 2 && 5=>1 
            // If L is 2, then we just need to compare two characters. Else
            // need to check two corner characters and value of dp[i+1][j-1]
            if (L == 2)
                dp[i][j] = (str.charAt(i) == str.charAt(j));
            else
                dp[i][j] = (str.charAt(i) == str.charAt(j)) && dp[i + 1][j - 1];
        }
    }
 
    for (int i = 0; i < n; i++)
    {
        /*If the substring from index 0 to i is a palindrome, then the minimum number of cuts is 0,
         since no partitioning is needed. For example, if the string is “nitin” and i is 4, 
         then the substring is “nitin” which is a palindrome, so minCuts[4] is 0.*/ 
        if (dp[0][i])
            minCuts[i] = 0;
        else
        {
            minCuts[i] = Integer.MAX_VALUE;
           /* If the substring from index 0 to i is not a palindrome, then the minimum number of cuts 
           is the minimum of all possible cuts that can be made by partitioning the substring into two parts: 
           one from index 0 to j and another from index j+1 to i. For each possible value of j,
           we check if the second part is a palindrome and add 1 to the minimum number of cuts for the first part.
           We take the minimum of all these values as the answer. For example, if the string is “banana” and i is 5, 
           then the substring is “banana” which is not a palindrome, so we try all possible values of j from 0 to 4 
           and find that minCuts[5] is 1, which corresponds to the partition [“b”, “anana”]. */
            for (int j = 0; j < i; j++)
            {
                if (dp[j + 1][i] && 1 + minCuts[j] < minCuts[i])
                    minCuts[i] = 1 + minCuts[j];
            }
        }
    }
    //Printing dp[][]
     for(int i=0; i<dp.length; i++) {
        for(int j=0; j<dp[0].length; j++) {
            System.out.print(dp[i][j] + " ");
        }
        System.out.println();
     }

    // Return the min cut value for complete string. i.e., str[0..n-1]
    return minCuts[n - 1];
    }




    public static void main(String args[]) {
          String str = "aaabba";
          System.out.println(palindromicPartition(str));
    }
}
