import java.util.*;

public class PrimAlgoMST {

        static class Edge {
            int src;
            int dest;
            int wt;
            public Edge(int s, int d, int w) {
                this.src = s;
                this.dest = d;
                this.wt = w;
            }
        }

        public static void createGraph(ArrayList<Edge>[] g) {
            //Null ArrayList -> Empty ArrayList = initiallization
            for(int i=0; i<g.length; i++) {
                g[i] = new ArrayList<>();
            }

            g[0].add(new Edge(0, 1, 10));
            g[0].add(new Edge(0, 2, 15));
            g[0].add(new Edge(0, 3, 30));
            g[1].add(new Edge(1, 0, 10));
            g[1].add(new Edge(1, 3, 40));
            g[2].add(new Edge(2, 0, 15));
            g[2].add(new Edge(2, 3, 50));

        }

        public static class Pair implements Comparable<Pair> {
           int vertex;
           int cost;
           public Pair(int v, int c) {
              this.vertex = v;
              this.cost = c;
           }

           @Override
           public int compareTo(Pair p2) {
                 return this.cost - p2.cost;
           }
        }


    //Prim algo -> Based on MST
    public static void primAlgo(ArrayList<Edge>[] g) {
           boolean vis[] = new boolean[g.length];
           PriorityQueue<Pair> pq = new PriorityQueue<>();

           int finalCost = 0;
           pq.add(new Pair(0, 0));
           while(!pq.isEmpty()) {
                Pair curr = pq.remove();
                if(!vis[curr.vertex]) {
                    vis[curr.vertex] = true;
                    finalCost += curr.cost;
                    //NeighBours
                    for(int i=0; i<g[curr.vertex].size(); i++) {
                         Edge e = g[curr.vertex].get(i);
                         pq.add(new Pair(e.dest, e.wt));
                    }
                }
           }
           System.out.println("FinalCost is = " + finalCost);
    }
    
    public static void main(String args[]) {
         int V = 7;
         ArrayList<Edge>[] g = new ArrayList[V];
         createGraph(g);
         primAlgo(g);
    }
}
