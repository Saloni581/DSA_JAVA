public class TilingProblem {
    

    public static int tilingWays(int n){
        //Base Case
        if(n==0 || n==1){
            return 1;
        }
        //Work and Recursion
        return tilingWays(n-1)+tilingWays(n-2);
    }
    public static void main(String args[]){
           System.out.println(tilingWays(4));
    }
}
