import java.util.*;

//TC = 0(V+E)
public class ArticulationPoint {

    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] g) {
           //null AL -> Empty AL
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

           g[4].add(new Edge(4, 3));
    }


    public static void dfs(ArrayList<Edge>[] g, int curr, int par, int[] disTime, int[] lowDt,
                           int time, boolean vis[], boolean ap[]) {
           vis[curr] = true;
           disTime[curr] = lowDt[curr] = ++time;
           int children = 0;
           for(int i=0; i<g[curr].size(); i++) {
               Edge e = g[curr].get(i);
               if(par == e.dest) {
                continue;
               }
               else if(vis[e.dest]) {
                   lowDt[curr] = Math.min(lowDt[curr], disTime[e.dest]);
               }
               //case 2
               else {
                   dfs(g, e.dest, curr, disTime, lowDt, time, vis, ap);
                   lowDt[curr] = Math.min(lowDt[curr], lowDt[e.dest]);
                   if(par != -1 && disTime[curr] <= lowDt[e.dest]) {
                      //System.out.println("AP : " + curr);
                      ap[curr] = true;
                   }
                   children++;
               }
           }
           //case 1
           if(par == -1 && children > 1) {
            //System.out.println("AP : " + curr);
            ap[curr] = true;
           }
    }

    public static void getAP(ArrayList<Edge>[] g, int V) {
           int disTime[] = new int[V];
           int lowDT[] = new int[V];
           boolean vis[] = new boolean[V];
           //if there is a big graph so the condition of repeatation of APs is occur so to handle that condition 
           //We can make a boolean ap[] which will keep track of articulation points in array NOTE: TC will be same 
           // as 0(V+E) as there is some modifications in dfs only
           boolean ap[] = new boolean[V];
           int time = 0;
           for(int i=0; i<V; i++) {
              if(!vis[i]) {
                dfs(g, i, -1, disTime, lowDT, time, vis, ap);
              }
           }
           for(int i=0; i<V; i++) {
                if(ap[i]) {
                    System.out.println("AP : " + i);
                }
            }
    }
    public static void main(String args[]) {
            int V = 5;
            @SuppressWarnings("unchecked")
            ArrayList<Edge>[] g = new ArrayList[V];
            createGraph(g);
            getAP(g, V);
}
}