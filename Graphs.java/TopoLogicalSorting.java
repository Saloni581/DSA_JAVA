import java.util.*;
import java.util.Stack;

public class TopoLogicalSorting {
    
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
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }


    public static void topoLogicalSorting(ArrayList<Edge>[] g) {
        boolean vis[] = new boolean[g.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<g.length; i++) {
            if(!vis[i]) {
                topoLogicalSortingUtil(g, i, vis, s);
            }
        }
        while(!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }

    public static void topoLogicalSortingUtil(ArrayList<Edge>[] g, int curr, boolean vis[], Stack<Integer> s) {
            vis[curr] = true;
            for(int i=0; i<g[curr].size(); i++) {
                Edge e = g[curr].get(i);
                if(!vis[e.dest]) {
                    topoLogicalSortingUtil(g, e.dest, vis, s);
                }
            }
            s.push(curr);
    }
    public static void main(String args[]) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] g = new ArrayList[V];
        createGraph(g);
        topoLogicalSorting(g);
 }
}
