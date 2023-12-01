import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


public class CheapestFlight {

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


    static class Info {
        int vertex;
        int cost;
        int stops;
        public Info(int v, int c, int k) {
            this.vertex = v;
            this.cost = c;
            this.stops = k;
        }
    }

    public static void createGraph(int[][] flights, ArrayList<Edge>[] g) {
        //null AL -> Empty AL
        for(int i=0; i<g.length; i++) {
            g[i] = new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            g[src].add(e);
        }
    }

    public static int cheapestFlightWithKStops(int n, int flights[][], int src, int dest, int k) {
           ArrayList<Edge>[] g = new ArrayList[n];
           createGraph(flights, g);
            
           int weight[] = new int[n];
           for(int i=0; i<n; i++) {
              if(i != src) {
                weight[i] = Integer.MAX_VALUE;
              }
           }

           Queue<Info> q = new LinkedList<>();
           q.add(new Info(0,0,0));
           while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k) {
                break;
            }
            for(int i=0; i<g[curr.vertex].size(); i++) {
                 Edge e = g[curr.vertex].get(i);
                 int u = e.src;
                 int v = e.dest;
                 int wt = e.wt;
                 //Relaxation Step 
                 //1 st method
                //  if(weight[u] != Integer.MAX_VALUE && weight[u] + wt < weight[v] && curr.stops <= k) {
                //     weight[v] = weight[u] + wt;
                //     q.add(new Info(v, weight[v], curr.stops+1));
                //  }
                // 2nd Method
                if(curr.cost+wt < weight[v] && curr.stops <= k) {
                    weight[v] = curr.cost+ wt;
                    q.add(new Info(v, weight[v], curr.stops+1));
                }
            }
           }
            
           //Weight[dest]
           if(weight[dest] == Integer.MAX_VALUE) {
               return -1;
           }
           else {
            return weight[dest];
           }
    }
 

public static void main(String args[]) {
    int n = 5;
    int flights[][] = {{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10},{3, 1, 1}, {1, 4, 3}};
    int src = 2, dest = 1, k = 1;
    System.out.println(cheapestFlightWithKStops(n, flights, src, dest, k));
}
}
