import java.util.*;
//To find shortest distance on the basis of weight of the edges

public class DijkstraAlgo {
    static class Edge {
        int src;
        int dest;
        int weight;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] g) {
        for(int i=0; i<g.length; i++) {
            g[i] = new ArrayList<>();
         }

         g[0].add(new Edge(0, 1, 2));
         g[0].add(new Edge(0, 2, 4));

         g[1].add(new Edge(1, 3, 7));
         g[1].add(new Edge(1, 2, 1));
        
         g[2].add(new Edge(2, 4, 3));
        
         g[3].add(new Edge(3, 5, 1));

         g[4].add(new Edge(4, 3, 2));
         g[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int path;
        public Pair(int n, int p) {
            this.node = n;
            this.path = p;
        }

        @Override
        public int compareTo(Pair p2) {
               return this.path - p2.path;
        }
    }

    public static void dijkstraAlgorithm(ArrayList<Edge>[] g, int src) {
           int weight[] = new int[g.length];
           //Except src Node other Nodes should be initialze with +infinity as their shortest dist is not confirm yet
           for(int i=0; i<g.length; i++)  {
            if(i != src) {
                weight[i] = Integer.MAX_VALUE;
            }
           }
           boolean vis[] = new boolean[g.length];
           PriorityQueue<Pair> pq = new PriorityQueue<>();
           //Adding src node in pq
           pq.add(new Pair(src, 0));
           while(!pq.isEmpty()) {
                Pair curr = pq.remove();
                //NeighBours
                for(int i=0; i<g[curr.node].size(); i++) {
                    Edge e = g[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;
                    if(weight[u] + wt < weight[v]) {
                        weight[v] = weight[u] + wt;  //Updating min weight from src to distance
                        pq.add(new Pair(v, weight[v]));
                    }
                }
           }

           //Printing Shortest paths from source to destination
           for(int i=0; i<weight.length; i++) {
               System.out.print(weight[i]+" ");
           }
           System.out.println();
    }

    public static void main(String args[]) {
           int V = 8;
           @SuppressWarnings("unchecked")
           ArrayList<Edge>[] g = new ArrayList[V];
           createGraph(g);

           int src = 0;
           dijkstraAlgorithm(g, src);
    }
}
