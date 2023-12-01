import java.util.*;
import java.util.Stack;

public class StronglyConnectedComponents {
    static class Edge {
        int src; 
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] g) {
        for(int i=0; i<g.length; i++) {
            g[i] = new ArrayList<>();
        }
        g[0].add(new Edge(0, 2));
        g[0].add(new Edge(0, 3));

        g[1].add(new Edge(1, 0));

        g[2].add(new Edge(2, 1));

        g[3].add(new Edge(0, 4));
    }

     public static void topSort(ArrayList<Edge>[] g, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for(int i=0; i<g[curr].size(); i++) {
            Edge e = g[curr].get(i);
            if(!vis[e.dest]) {
                topSort(g, e.dest, vis, s);
            }
        }
        s.push(curr);
     }

     //dfs
     public static void dfs(ArrayList<Edge>[] g, int curr, boolean vis[]) {
         vis[curr] = true;
         System.out.print(curr+" ");
        for(int i=0; i<g[curr].size(); i++) {
            Edge e = g[curr].get(i);
            if(!vis[e.dest]) {
               dfs(g, e.dest, vis);
            }
        }
     }



     public static void kosaRajuAlgo(ArrayList<Edge>[] g, int V) {
            //step 1
            Stack<Integer> s = new Stack<>();
            boolean vis[] = new boolean[V];
            for(int i=0; i<V; i++) {
                if(!vis[i]) {
                    topSort(g, i, vis, s);
                }
            }
            //step 2
            ArrayList<Edge> transpose[] = new ArrayList[V];
            //initialization null AL -> Empty AL
            for(int i=0; i<g.length; i++) {
                vis[i] = false;
                transpose[i] = new ArrayList<Edge>();
            }

            for(int i=0; i<V; i++) {
                for(int j=0; j<g[i].size(); j++) {
                    Edge e = g[i].get(j); //e.src -> e.dest
                    transpose[e.dest].add(new Edge(e.dest, e.src)); //reverse Edge
                }
            }

            //step 3
            while(!s.isEmpty()) {
                int curr = s.pop();
                if(!vis[curr]) {
                    System.out.print("SCC -> ");
                    dfs(transpose, curr, vis); //SCC
                    System.out.println();
                }
            }
     }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge>[] g = new ArrayList[V];
        createGraph(g);
        kosaRajuAlgo(g, V);
    }
}
