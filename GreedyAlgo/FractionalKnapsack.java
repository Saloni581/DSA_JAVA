import java.util.*;
import java.util.Arrays;

public class FractionalKnapsack {
    
    public static int fractionalKnapsack(int val[], int weight[], int w) {
           //1
           double ratio[][] = new double[val.length][2]; // only two col
           //2  
           for(int i=0; i<val.length; i++) {
              //0th col = index
              ratio[i][0] = i;
              //1th col = ratio
              ratio[i][1] = val[i] / (double)weight[i];
           }
           //sorting in ascending order
           Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

           int capacity = w;
           int finalVal = 0;
           //traversing on ratio
           for(int i=ratio.length-1; i>=0; i--) {
              int idx = (int)ratio[i][0];
              if(capacity >= weight[idx]) {
                //Include full item
                finalVal += val[idx]; //adding val
                capacity -= weight[idx]; //subtracting weight
              }
              else{
                //Include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;//not working in every condition
                break;
              }
           }
           return finalVal;
    }
    public static void main(String args[]) {

        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;
        System.out.println(fractionalKnapsack(val, weight, w));
    }
}
