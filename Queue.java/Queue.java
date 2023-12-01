import java.util.*;

public class Queue{

    //⭐ ARRAY QUEUE
    static class QueueA{
        static int arr[];
        static int size;
        static int rear;

        QueueA(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }

        //Empty 
        public static boolean isEmpty(){
            return rear == -1;
        }

        //Add 
        public static void add(int data){
            //check is arr[] is full or not
            if(rear == size-1){
                System.out.println("full");
                return;
            }
            //Otherwise
            rear = rear+1;
            arr[rear] = data;
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty");
                return -1;
            }
            int front = arr[0];
            //Removing front
            for(int i=0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            rear = rear-1;
            return front;
        }
        
        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty");
                return -1;
            }
            int front = arr[0];
            return front;
        }
    }

    //⭐ CIRCULAR QUEUE

    static class QueueB {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        QueueB(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        //isEmpty
        public static boolean isEmpty(){
            return (rear == -1 &&  front == -1);
        }

        //isFull
        public static boolean isFull(){
            return (rear+1) % size == front;
        }


        //add
        public static void add(int data){
            if(isFull()){
              System.out.println("Full");
              return;
            }

            //if adding 1st elm 
            if(front == -1){
                front = 0;
            }
            rear = (rear+1) % size; 
            arr[rear] = data;
        }

        //remove
        public  static int remove() {
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            int res = arr[front];

            //if last elm
            if(rear == front) {
                rear = front = -1;
            } else {
                front = (front+1) % size;
            }
            return res;
        }

        //peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty");
                return -1;
            }
            return arr[front];
        }

    }






    //⭐ LINKED LIST QUEUE  = 0(1)

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class QueueC {
           static Node front = null;
           static int size;
           static Node rear = null;

          //isEmpty
          public static boolean isEmpty() {
                return front == null && rear == null;
          }

          //add
          public static void add(int data) {
                Node newNode = new Node(data);
                size++;
                if(front == null){
                    front = rear = newNode;
                }
                rear.next = newNode;
                rear = newNode;
          }

          //remove
          public static int remove() {
                if(isEmpty()) {
                    return -1;
                }
                 int frontData = front.data;
                 if(rear == front) {
                    rear = front = null;
                 }
                 else {
                    front = front.next;
                 }
                 size--;
                 return frontData;
          }

          //peek()
          public static int peek() {
                if(isEmpty()) {
                    System.out.println("Empty");
                    return -1;
                }
                return front.data;
          }

    }


   //Creating Queue Structure using ArrayList
   
   static int front = -1;
   static int rear = -1;
   //isEmpty()
   public static boolean isEmpty() {
        return (rear == -1 || front == -1);
   }
   //isFull()
   public static boolean isFull() {
        return rear == 
   }



    public static void main(String args[]){
           QueueC q = new QueueC();
        //   Queue<Integer> q = new LinkedList<Integer>();
            
           q.add(1);
           q.add(2);
           q.add(3);
        //    System.out.println(q.remove());
        //    q.add(4);
        //    System.out.println(q.remove());
        //    q.add(5);
          
           
           while(!q.isEmpty()) {
                 System.out.println(q.peek());
                 q.remove();
           }
    }
}