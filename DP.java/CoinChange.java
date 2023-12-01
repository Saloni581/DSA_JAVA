public class CoinChange {
    
    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];
        //initialization
        //row 
        for(int i=0; i<n+1; i++) {
            dp[i][0] = 1;
        }
        //column 
        // for(int j=0; j<sum+1; j++) {
        //     dp[0][j] = 0;
        // }

        //calculating the number of ways
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                //Valid
                if(coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];  //adding all cases
                }
                //Exclude
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println();
        //printing dp[][]
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][sum];
    }




    public static int minCoinChange(int coins[], int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        if(amount == 0) {
            return 0;
        }
        if(n == 1) {
            if(coins[0] > amount && coins[0] < amount) {
                return -1;
            }
        }
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<amount+1; j++) {
                if(coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                    System.out.print(dp[i][j] + " ");
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        //printing 
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][amount];
    }
    public static void main(String args[]) {
        int coins[] = {2, 5, 3, 6};
        int sum = 10;
        //Count the total number of ways

        // int coins[] = {1,2,5};
        // int  amount = 11;
        //System.out.println(minCoinChange(coins, amount));
        System.out.println(coinChange(coins, sum) + " Ways Exist");
    }
}
