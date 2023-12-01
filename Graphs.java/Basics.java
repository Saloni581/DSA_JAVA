import java.util.*;

public class Basics{

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
    public static void main(String args[]) {
           int V = 5;
           @SuppressWarnings("unchecked")
           ArrayList<Edge>[] graph  = new ArrayList[V]; // null ArrayList -> empty ArrayList
          
           //Converting null ArrayList to empty ArrayList
           for(int i=0; i<V; i++) {
              graph[i] = new ArrayList<>();
           }

           //Storing Values as Adjacency List
           // 0 th vertix
           graph[0].add(new Edge(0, 1, 5));
           // 1 st vertix
           graph[1].add(new Edge(1, 0, 5));
           graph[1].add(new Edge(1, 2, 1));
           graph[1].add(new Edge(1, 3, 3));
           //2 nd vertix
           graph[2].add(new Edge(2, 1, 1));
           graph[2].add(new Edge(2, 3, 1));
           graph[2].add(new Edge(2, 4, 2));
           //3 rd vertix
           graph[3].add(new Edge(3, 1, 3));
           graph[3].add(new Edge(3, 2, 1));
           //4 rt vertix
           graph[4].add(new Edge(4, 2, 2));


           //2's NeighBour
           for(int i=0; i<graph[2].size(); i++) {
              Edge e = graph[2].get(i);
              System.out.print(e.dest + " ");
           }

    }
}