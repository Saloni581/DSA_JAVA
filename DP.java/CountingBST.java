public class CountingBST {

    public static int formBST(int nodes) {

        int dp[] = new int[nodes+1];
        //initialization
        dp[0] = 1; // 0 node can be a considered as NULL node which form a NULL BST = only in one way
        dp[1] = 1; // 1 node can form BST = in one way
       // dp[2] = 2; // 2 nodes can form BST in = 2 ways
        
        for(int i=2; i<nodes+1; i++) {
            //finding possible formation of BST for each i nodes
            for(int j=0; j<i; j++) {
                int leftNodes = dp[j];
                int rightNodes = dp[i-j-1];
                dp[i] += leftNodes * rightNodes;
            }
        }
        return dp[nodes];
    }
    public static void main(String args[]) {
        int nodes = 4;
        System.out.println(formBST(nodes));
    }
}
