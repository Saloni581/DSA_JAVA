import java.util.*;

public class ConnectN_Ropes{

    public static int minCostByAddingRopes(int ropes[]) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;
        for(int i=0; i<ropes.length; i++) {
            pq.add(ropes[i]);
        }
        while(pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min+min2);
        }
        return cost;
    }

    public static void main(String args[]) {
          int ropes[] = {4,3,2,6};
          System.out.print(minCostByAddingRopes(ropes));;
    }
}