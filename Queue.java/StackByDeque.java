import java.util.*;
import java.util.Deque;


public class StackByDeque {
    
   static class Stack {
    static Deque<Integer> dq = new LinkedList<>();

    public static boolean isEmpty() {
        return dq.isEmpty();
    }
    
    public static void push(int data) {
        dq.addLast(data);
    }


    public static int pop() {
        int top = dq.removeLast();
        return top;
    }

    public static int peek() {
        return dq.getLast();
    }
   }
    public static void main(String args[]) {
         
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
