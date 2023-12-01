import java.util.*;

public class TarjanAlgo {
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> g[]) {
        for(int i=0; i<g.length; i++) {
            g[i] = new ArrayList<>();
        }
        g[0].add(new Edge(0, 1));
        g[0].add(new Edge(0, 2));
        g[0].add(new Edge(0, 3));

        g[1].add(new Edge(1, 0));
        g[1].add(new Edge(1, 2));

        g[2].add(new Edge(2, 0));
        g[2].add(new Edge(2, 1));

        g[3].add(new Edge(3, 0));
        g[3].add(new Edge(3, 4));
        g[3].add(new Edge(3, 5));

        g[4].add(new Edge(4, 3));
        g[4].add(new Edge(4, 5));

        g[5].add(new Edge(0, 3));
        g[5].add(new Edge(0, 4));
    }

    public static void dfs(ArrayList<Edge>[] g, int curr, int par, int[] disTime, 
                            int lowDt[], boolean vis[], int time) {
           vis[curr] = true;
           disTime[curr] = lowDt[curr] = ++time;

           for(int i=0; i<g[curr].size(); i++) {
            Edge e =  g[curr].get(i);
            //Case 1
            if(e.dest == par) {
                continue;
            }
            //Case 2
            else if(!vis[e.dest]) {
                dfs(g, e.dest, curr, disTime, lowDt, vis, time);
                lowDt[curr] = Math.min(lowDt[curr], lowDt[e.dest]);
                //Checking the bridge condition
                if(disTime[curr] < lowDt[e.dest]) {
                    System.err.println("Bridge: " + curr + "-----" + e.dest);
                }
            }
            //Case 3
            else {
                lowDt[curr] = Math.min(lowDt[curr], disTime[e.dest]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edge>[] g, int V) {
        int disTime[] = new int[V];
        int lowDt[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                dfs(g, i, -1, disTime, lowDt, vis, time);
            }
        }
    }
    public static void main(String args[]) {
           int V = 6;
           ArrayList<Edge>[] g = new ArrayList[V];
           createGraph(g);
           tarjanBridge(g, V);
    }
}
