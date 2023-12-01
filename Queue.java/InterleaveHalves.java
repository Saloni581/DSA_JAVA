import java.util.*;
import java.util.Queue;

// remember girl's choti 💇 Here in this Question 😆😁
public class InterleaveHalves {
    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<Integer>(); // 1 2 3 4 5 6 7 8 9 10
        int size =q.size()/2;  // 1 2 3 4 5 (AND) 6 7 8 9 10

        for(int i=0; i<size; i++) {
            firstHalf.add(q.remove());// 1 2 3 4 5
        }
        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());  //(6 7 8 9 10).add(1 2 3 4 5)
            q.add(q.remove());  //MAIN        //(1 6 2 7 3 8 4 9 5 10) = final answer
        }
}
    public static void main(String args[]) {
           Queue<Integer> q = new LinkedList<>();
           q.add(1);
           q.add(2);
           q.add(3);
           q.add(4);
           q.add(5);
           q.add(6);
           q.add(7);
           q.add(8);
           q.add(9);
           q.add(10);

           interLeave(q);

           while(!q.isEmpty()) {
            System.out.println(q.remove()+" ");
           }
           System.out.println();
    }
}