import java.util.*;

public class NearestCars {
    
    public static class Point implements Comparable<Point>{
          int x; 
          int y;
          int disSq;
          int idx;
          public Point(int x, int y, int disSq, int idx) {
            this.x = x;
            this.y =  y;
            this.disSq = disSq;
            this.idx = idx;
          }

          @Override
          public int compareTo(Point p2) {
            return this.disSq - p2.disSq;
          }
    }
    public static void main(String args[]) {
        int points[][] = {{3,3}, {5,-1}, {-2,4}};
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<points.length; i++) {
            int disSq = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.add(new Point(points[i][0], points[i][1], disSq, i));
        }

        //nearest K Cars
        for(int i=0; i<k; i++) {
            System.out.print("C" +pq.remove().idx+" ");
        }
    }
}
