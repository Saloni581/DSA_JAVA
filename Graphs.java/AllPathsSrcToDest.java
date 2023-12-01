import java.util.*;

//Time Complexity = 0(V^v) = Exponential TC -> Not Effeicient
public class AllPathsSrcToDest {
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
        g[0].add(new Edge(0, 3));
        g[2].add(new Edge(2, 3));
        g[3].add(new Edge(3, 1));
        g[4].add(new Edge(4, 0));
        g[4].add(new Edge(4, 1));
        g[5].add(new Edge(5, 0));
        g[5].add(new Edge(5, 2));
    }


    //All Paths from source to destination
    public static void printAllPaths(ArrayList<Edge>[] g, int src, int dest, String path) {
        //if I am source and I am Destination also
        if(src == dest) {
            System.out.println(path+dest);
        }

        //Call for NeighBors
        for(int i=0; i<g[src].size(); i++) {
            Edge e = g[src].get(i);
            printAllPaths(g, e.dest, dest, path+src);
        }
    }
    public static void main(String args[]) {
           int V = 6;
           @SuppressWarnings("unchecked")
           ArrayList<Edge>[] g =  new ArrayList[V];
           createGraph(g);
           int src = 5, dest = 1;
           printAllPaths(g, src, dest, "");
    }
}
