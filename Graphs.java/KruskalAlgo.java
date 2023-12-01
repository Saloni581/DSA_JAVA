import java.util.*;

public class KruskalAlgo {

    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }
 //*****************Union & find Code********************************/
    static int n = 4;
    static int par[] = new  int[n];
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
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
           int parA = find(a);
           int parB = find(b);

           //3 Conditions
           if(rank[parA] == rank[parB]) {
              //A == B
              par[parB] = parA;
              rank[parA]++;
           }
           else if(rank[parA] < rank[parB]) {
            // A -> B
                par[parA] = parB;
           }
           else {
            //  B -> A
            par[parB] = parA;
           }
    }

    //CreateGraph => EdgeList Type of Graph Creation
    public static void createGraph(ArrayList<Edge> edges) {
            edges.add(new Edge(0, 1, 10));
            edges.add(new Edge(0, 2, 15));
            edges.add(new Edge(0, 3, 30));
            edges.add(new Edge(1, 3, 40));
            edges.add(new  Edge(2, 3, 50));
    }


    public static void kruskalAlgoMST(ArrayList<Edge> edges, int V) {
           initialization();
           Collections.sort(edges);
           int mstCost = 0;
           int count = 0;
           for(int i=0; count<V-1; i++) {
             Edge e = edges.get(i);
             //Cycle Detection
             int parA = find(e.src); // a = src
             int parB = find(e.dest); // b = dest

             if(parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
             }
           }
           System.out.println(mstCost);
    }
    public static void main(String args[]) {
           int V = 4;
           ArrayList<Edge> edges = new ArrayList<>();
           createGraph(edges);
           kruskalAlgoMST(edges, V);
    }
}
