public class DoublyLL {
    
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;


    //Print method of LinkedList
    public void printLL(){

        // if(head == null){
        //     System.out.println("ll is empty");
        //     return;
        // }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //add First
    public  void addFirst(int data){
          //Create new Node
          Node newNode = new Node(data);
          size++;
          if(head == null){
            head = tail = newNode;
            return;
          }

          newNode.next = head;
          head.prev = newNode;
          head = newNode;
    }


    //remove from first
    public int removeFirst(){
        //Base Cases
        if(head == null){
            // head = tail = null;
            System.out.println("DLL is Empty");
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }


    //Reverse a DLL
    public void reverseDLL(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev.next = curr; //Extra step 
            prev = curr;
            curr = next;
        }
        head = prev;
    }

//addLast
public void addLast(int data){
        //Base Cases
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = null;
}

//removeLast
public int removeLast(){
    //Base Cases
    if(head == null){
        return -1;
    }
    if(size == 1){
        int val = head.data;
        head = tail = null;
        size--;
        return val;
    }

    int val = tail.data;
    tail.prev = tail;
    tail.prev.next = null;
    size--;
    return val;

}



    public static void main(String args[]){
         DoublyLL dll = new DoublyLL();
         dll.addFirst(3);
         dll.addFirst(2);
         dll.addFirst(1);
        //  dll.printLL();
        //  System.out.println(size);
        //  dll.removeFirst();
        //  dll.printLL();
        //  System.out.println(size);
         //dll.reverseDLL();
         //dll.printLL();
         dll.addLast(4);
         dll.printLL();
         dll.removeLast();
         dll.printLL();
    }
}
