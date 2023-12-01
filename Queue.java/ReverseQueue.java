import java.util.*;
import java.util.Queue;

public class ReverseQueue {


    //⏲️ TC = 0(n)
    //🌌 SC = 0(n)
    public static void queueReversal(Queue<Integer> q) {
         Stack<Integer> s = new Stack<>();
         while(!q.isEmpty()) {
            s.push(q.remove());
         }
         while(!s.isEmpty()) {
            q.add(s.pop());
         }
    }
    public static void main(String args[]) {
           Queue<Integer> newQ = new LinkedList<>();

           newQ.add(1);
           newQ.add(2);
           newQ.add(3);
           newQ.add(4);
           newQ.add(5);
           newQ.add(6);

           queueReversal(newQ);

           while(!newQ.isEmpty()) {
            System.out.println(newQ.remove()+" ");
           }
    }
    
}
