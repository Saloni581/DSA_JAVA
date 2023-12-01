//Time Complexity = 0(V*E)
import java.util.*;

public class BellmanFordAlgo {
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

         g[1].add(new Edge(1, 2, -4));
    
         g[2].add(new Edge(2, 3, 2));
        
         g[3].add(new Edge(3, 4, 4));

         g[4].add(new Edge(4, 1, -1));
    }


    //Bellman ford Algorithm is used in Negetive Weight Values
    public static void bellmanFordAlgo(ArrayList<Edge>[] g, int src) {
           //declaring distance arr[]
           int dist[] = new int[g.length];
           //initializing distance arr[]
           for(int i=0; i<dist.length; i++) {
              if(i != src) {
                dist[i] = Integer.MAX_VALUE;
              }
           }

           int V = g.length;
           for(int i=0; i<V-1; i++) {
               //Edges = TC = (O(E)) -> Time complexity will remain same by any method you use
               for(int j=0; j<g.length; j++) {
                   for(int k=0; k<g[j].size(); k++) {
                      Edge e = g[j].get(k);
                       //u, v, wt
                       int u = e.src;
                       int v = e.dest;
                       int weight = e.weight;
                       //Special condition + Relaxation Step
                       if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                       }
                   }
               }
           }
           //Print 
           for(int i=0; i<dist.length; i++) {
                System.out.print(dist[i] +" ");
           }
           System.out.println();

    }


    //Bellman Ford Algo On ArrayList<Edge> -> not ArrayList<Edge>[]

    public static void createGraph(ArrayList<Edge> g) {
         g.add(new Edge(0, 1, 2));
         g.add(new Edge(0, 2, 4));
         g.add(new Edge(1, 2, -4));
         g.add(new Edge(2, 3, 2));
         g.add(new Edge(3, 4, 4));
         g.add(new Edge(4, 1, -1));
    }


    //Bellman ford Algorithm is used in Negetive Weight Values
    public static void bellmanFordAlgo(ArrayList<Edge> g, int src, int V) {
           //declaring distance arr[]
           int dist[] = new int[V];
           //initializing distance arr[]
           for(int i=0; i<dist.length; i++) {
              if(i != src) {
                dist[i] = Integer.MAX_VALUE;
              }
           }
           for(int i=0; i<V-1; i++) {
               //Edges = TC = (O(E)) -> Time complexity will remain same by any method you use
                     for(int j=0; j<g.size(); j++) {
                      Edge e = g.get(j);
                       //u, v, wt
                       int u = e.src;
                       int v = e.dest;
                       int weight = e.weight;
                       //Special condition + Relaxation Step
                       if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                       }
                   }
               }
           
           //Print 
           for(int i=0; i<dist.length; i++) {
                System.out.print(dist[i] +" ");
           }
           System.out.println();
    }

    public static void main(String args[]) {
        int V = 5;
        //ArrayList<Edge>[] g = new ArrayList[V];
        ArrayList<Edge> g = new ArrayList<>();
        createGraph(g);
        //bellmanFordAlgo(g, 0);
        bellmanFordAlgo(g, 0, V);
    }
}
