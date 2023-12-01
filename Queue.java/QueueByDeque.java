import java.util.*;
import java.util.Deque;

public class QueueByDeque {
    
    static class Queue {
          static Deque<Integer> dq = new LinkedList<>();

          //isEmpty()
          public static boolean isEmpty() {
            return dq.isEmpty();
          }

          //add()
          public static void add(int data) {
              dq.addLast(data);
          }

          //remove
          public static int remove() {
            return dq.removeFirst();
          }

          //peek() 
          public static int peek() {
            return dq.getFirst();
          }
    }
    public static void main(String args[]) {
          Queue q = new Queue();
          q.add(1);
          q.add(2);
          q.add(3);
          q.add(4);

          while(!q.isEmpty()) {
            System.out.println(q.peek() + " ");
            q.remove();
          }
    }
}
