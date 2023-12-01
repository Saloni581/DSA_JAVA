import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class Stack{


    //Implementation of stack using ArrayList 
    // static  class Stacks{
    //     static ArrayList<Integer> list = new ArrayList<>();

    //     //isEmpty 
    //     public static boolean isEmpty() {
    //         return list.size() == 0;
    //     }

    //     //push 
    //     public static void push(int data) {
    //         list.add(data);
    //     }

    //     //pop
    //     public static int pop() {
    //         //Corner Case
    //         if(isEmpty()){
    //             return -1;
    //         }


    //         int top = list.get(list.size()-1);
    //         list.remove(list.size()-1);
    //         return top;
    //     }
    //     //peek
    //     public static int peek() {
    //         //Corner Case
    //         if(isEmpty()){
    //             return -1;
    //         }

    //          int top = list.get(list.size()-1);  
    //          return top;
    //     }
    // }


    //Implementation of stack using LinkedList

    public static class Node {
        int data;
        Node next;
        //Constructor
        public Node(int data){
              this.data = data;
              this.next = null;
        }
    }
    public static class Stackss {

        static Node head = null;
        
        //isEmpty
        public static boolean isEmpty() {
            return head == null;
        }

        //push
        public static void push(int data) {
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
            }
            newNode.next = head;
            head = newNode;
        }
        
        //pop
        public static int pop() {
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        //peek
        public static int peek() {
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }



    public static void main(String args[]){
        //    Stacks s = new Stacks();
        //    s.push(1);
        //    s.push(2);
        //    s.push(3);
        //    s.push(4);
        //    s.push(5);
        //    s.push(6);

        //    while(!s.isEmpty()) {
        //        System.out.println(s.peek()+" ");
        //        s.pop();
        //    }

        //    Stackss ss = new Stackss();
        //       ss.push(1);
        //       ss.push(2);
        //       ss.push(3);
        //       ss.push(4);
        //       ss.push(5);
        //       ss.push(6);

        //    while(!ss.isEmpty()) {
        //         System.out.print(ss.peek()+" ");
        //         ss.pop();
        //    }


        //JCf
        Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

          while(!s.isEmpty()) {
               System.out.println(s.peek()+" ");
               s.pop();
           }

    }
}