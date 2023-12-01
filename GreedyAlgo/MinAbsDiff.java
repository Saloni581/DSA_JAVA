import java.util.*;

public class MinAbsDiff {
    
    public static int minAbsDiff(int a[], int b[]) {
          Arrays.sort(a);
          Arrays.sort(b);
          int minDiff = 0;
          for(int i=0; i<a.length; i++) {
              minDiff += Math.abs(a[i]-b[i]);
          }
          return minDiff;
    }
    public static void main(String args[]) {
           int A[] = {4,1,8,7};
           int B[] = {2,3,6,5};

           System.out.println(minAbsDiff(A, B));
    }
}
