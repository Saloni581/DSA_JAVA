import java.util.*;
import java.util.Queue;

public class KahnAlgoTopSortBFS {
    
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
             this.src = s;
             this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge>[] g) {
        for(int i=0; i<g.length; i++) {
            g[i] = new ArrayList<>();
        }
        g[2].add(new Edge(2, 3));
        g[3].add(new Edge(3, 1));
        g[4].add(new Edge(4, 0));
        g[4].add(new Edge(4, 1));
        g[5].add(new Edge(5, 0));
        g[5].add(new Edge(5, 2));
    }


    //Helper Function()
    public static void calculateIndeg(ArrayList<Edge>[] g, int[] Indeg) {
           for(int i=0; i<g.length; i++) {
               for(int j=0; j<g[i].size(); j++) {
                Edge e = g[i].get(j);
                Indeg[e.dest]++;
               }
           }
    }
    //Topological Sort using BFS -> Kahn's Algorithm
    public static void topSortBFS(ArrayList<Edge>[] g) {
        int inDeg[] = new int[g.length];
        calculateIndeg(g, inDeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDeg.length; i++) {
            if(inDeg[i] == 0) {
                q.add(i);
            }
        }
        //bfs
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" "); //printing Topological Sort Order
            //Calling for neighBors
            for(int i=0; i<g[curr].size(); i++) {
                Edge e = g[curr].get(i);
                inDeg[e.dest]--;
                if(inDeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
            
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topSortBFS(graph);
    }
}
