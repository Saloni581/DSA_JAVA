import java.util.Arrays;

public class MinCostToCutStick {
    
    public static int minCost(int n, int[] cuts) {
        
        // sort the cuts array and add 0 and n
        Arrays.sort(cuts);
        int[] newCuts = new int[cuts.length + 2];
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        for (int i = 0; i < cuts.length; i++) {
            newCuts[i + 1] = cuts[i];
        }
        //newCuts[] = {0, 1, 2, 4, 5, 6, 9}
        
        // create a dp array to store the minimum cost
        int[][] dp = new int[newCuts.length][newCuts.length];
        
        // loop over all possible lengths and positions of the stick
        for (int len = 2; len < newCuts.length; len++) {
            for (int i = 0; i + len < newCuts.length; i++) {
                int j = i + len;
                // initialize the cost as the maximum possible value
                dp[i][j] = Integer.MAX_VALUE;
                // loop over all possible cuts between newCuts[i] and newCuts[j]
                for (int k = i + 1; k < j; k++) {
                    // update the cost as the minimum of the current cost and the cost of cutting at newCuts[k]
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + newCuts[j] - newCuts[i]);
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
        // return the final answer
        return dp[0][newCuts.length - 1];
    }

    
    public static void main(String args[]) {
        int cuts[] = {5,6,1,4,2};
        int n = 9;
        System.out.println(minCost(n, cuts));
    }
}
