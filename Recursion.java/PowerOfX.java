public class PowerOfX {
    
    public static int calculatePower(int x, int n){
           //Base Case
           if(n==0){
            return 1;
           }
           //Work && recursion
           return x*calculatePower(x, n-1);
    }


    //Optimised Code for Calculating power of x
    public static int optimizedCalculationOfPower(int x, int n){
          //Base Case
          if(n == 0){
            return 1;
          }
          //Work && Recursion
          int halfPower = optimizedCalculationOfPower(x, n/2);
          int halfPowerSq = halfPower*halfPower;
          if(n % 2 != 0){
            halfPowerSq = x*halfPower*halfPower;
          }
          return halfPowerSq;
    }
    public static void main(String args[]){
           System.out.println(calculatePower(10, 10));
           System.out.println(optimizedCalculationOfPower(10, 10));
    }
}
