//Disjoint Sets 
import java.util.*;

public class UnionFindDS {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void initialization() {
           for(int i=0; i<par.length; i++) {
               par[i] = i;
           }
    }

    public static int find(int x) {
           if(x == par[x]) {
            return x;
           }

           //Path Compression Optimization
           return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
         int parA = find(a);
         int parB = find(b);

         if(rank[parA] == rank[parB]) {   // A == B
            par[parB] = parA;
            rank[parA]++;
         }
         else if(rank[parA] < rank[parB]) {  // A -> B
              par[parA] = parB;
         }
         else {
            par[parB] = parA;  // B -> A
         }
    }
    public static void main(String args[]) {
        initialization();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
}
