public class MinTriScore {

    public static int  minScoreTriangulationofPolygon(int[] values) {
        int n = values.length;
        int dp[][] = new int[n][n];
        //default initialization as 0 at each cell
        for(int len=2; len<n; len++) {
            for(int i=1; i<n-len; i++) {
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = values[i-1] * values[k] * values[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
        //printing dp arr
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[1][n-1];
    }
    public static void main(String[] args) {
        int values[] = {1, 3, 1, 4, 1, 5};
        System.out.println(minScoreTriangulationofPolygon(values));
    }
}
