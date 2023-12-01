import java.util.*;


//TC = (V+E)
public class CycleDetectionDirected {
    static class Edge {
        int src;
        int dest;
        public Edge(int s,int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }


    public static boolean isCycleUtil(ArrayList<Edge>[] g, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;
        for(int i=0; i<g[curr].size(); i++) {
            Edge e = g[curr].get(i);
            if(stack[e.dest]) { //if neighBor is already exists in the stack that means cycle exists
                //Cycle Exists
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(g, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static boolean isCycleDirectedG(ArrayList<Edge>[] g) {
           boolean vis[] = new boolean[g.length];
           boolean stack[] = new boolean[g.length];

           for(int i=0; i<g.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(g, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }


    
    
    public static void main(String args[]) {
           int V = 4;
           ArrayList<Edge>[] g = new ArrayList[V];
           createGraph(g);
           System.out.println(isCycleDirectedG(g));
    }
}
