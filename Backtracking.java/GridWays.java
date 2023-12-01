public class GridWays{
     
      public static int gridWays(int i, int j, int n, int m){
         //Base Case
         if(i == n-1 && j == m-1){ //Condition for last cell
            return 1;
         }
         else if(i == n || j == m){//Boundry cross condition
            return 0;
         }
         int w1 = gridWays(i+1, j, n, m);
         int w2 = gridWays(i, j+1, n, m);
         return w1+w2;
      }
       //Time Complexity = 2^(n+m)

       public static int fact(int n){
              int factorial = 1;
              for(int i=1; i<=n; i++){
                 factorial = factorial*i;
              }
              return factorial;
       }
      //  public static int gridWays(int i, int j, int n, int m){
      //   //Base Case
      //    if(i== n-1 && j == m-1){
      //       return 1;
      //    }
      //    else if(i == n || j == m){
      //       return 0;
      //    }
      //   //Recursion
      //    return fact(n-1+m-1)/(fact(n-1)*fact(m-1));
      //  }

       //Permutation Trick Code - Formula = (n-1+m-1)!/(n-1)(m-1)
       //Time Complexity = O(n+m)

    public static void main(String args[]){
          int n = 3, m = 3;
         //  System.out.println(gridWays(0,0,n,m));
         System.out.println(gridWays(0, 0, n, m)); 
}
}