import java.util.*;
public class MCM {


public static int matrixChainMultiplication(int arr[], int i, int j) {
    int minCost = Integer.MAX_VALUE;
    //single matrix cannot be multiply
    if(i == j) {
        return 0;//return cost as 0
    }
    //k is the variable which traverses the matrices from forming i to j where each matrix size = arr[i-1] X arr[i]
    for(int k=i; k<j; k++) {
        //k is dividing matrices into 2 sets
        //from i to itself order matrices
        int cost1 = matrixChainMultiplication(arr, i, k);
        //from itself to j order matrices
        int cost2 = matrixChainMultiplication(arr, k+1, j);
        //calculating total operations = A(aXb) . B(cXd) = Total operations = C(a.b.d)
        //where a = no. of rows of the first matrix 
        //d = no. of cols of the last matrix
        //b = common in first & last matrix (no. of cols in first & no. of rows in the last) 
        //we can take c also as it is common
        int cost3 = arr[i-1] * arr[k] * arr[j];
        int finalCost = cost1 + cost2 + cost3;
        //int finalCost = matrixChainMultiplication(arr, i, k) + matrixChainMultiplication(arr, k+1, j) + arr[i-1] * arr[k] * arr[j];
        minCost = Math.min(minCost, finalCost);
    }
    return minCost;
}

//MCM-> Memoization
public static int mcmMemoization(int arr[], int i, int j, int dp[][]) {
    if(i == j) {
        return 0;
    }
    if(dp[i][j] != -1) {
        return dp[i][j];
    }
    int ans = Integer.MAX_VALUE;
    for(int k=i; k<j; k++) {
        int cost1 = mcmMemoization(arr, i, k, dp);
        int cost2 = mcmMemoization(arr, k+1, j, dp);
        int cost3 = arr[i-1] * arr[k] * arr[j];
        ans = Math.min(ans, cost1+cost2+cost3);
    }
    return dp[i][j] = ans;
}


//MCM -> Tabulation
public static int mcmTabulation(int arr[]) {
    int n = arr.length;
    int dp[][] = new int[n][n];
    //initialization
    for(int i=0; i<n; i++) {
        dp[i][i] = 0;
    }
    //bottom-up filling 
    for(int len=2; len<n; len++) {
        for(int i=1; i<=n-len; i++) {
           int j = i+len-1;//col
           dp[i][j] = Integer.MAX_VALUE;
           for(int k=i; k<j; k++) {
              int cost1 = dp[i][k];//cut1
              int cost2 = dp[k+1][j];//cut2
              int cost3 = arr[i-1] * arr[k] * arr[j];
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
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;
        // int dp[][] = new int[n][n];
        // //initialization by -1 of all the cells
        // for(int i=0; i<n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // //System.out.println(matrixChainMultiplication(arr, 1, n-1));
        // System.out.println(mcmMemoization(arr, 1, n-1, dp));

        System.out.println(mcmTabulation(arr));
    }
}