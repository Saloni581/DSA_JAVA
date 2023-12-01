public class LinkedList{

     public static class Node{
        int data;
        Node next;
        //constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
     }
     public static Node head;
     public static Node tail;
     public static int size;


   // ⭐Methods
   //Add in a linked list at first place
   public void addFirst(int data){
    // step 1️⃣Create new Node
    Node newNode = new Node(data);
    //Tracking size of a LL
    size++;
    //Base Condition
    if(head ==  tail){
        head = tail = newNode;
    }
    //step 2️⃣newNode.next = head
    newNode.next = head;
    //step 3️⃣newNode.next = head
    head = newNode;
   }

   // Add in linked list at second place
    public void addLast(int data){ 
        Node newNode = new Node(data);
        //Tracking the size of a LL
        size++;
        //Base Condition
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    //Print method of LinkedList
    public static void printLL(){

        if(head == null){
            System.out.println("ll is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //Add in the Middle
    public void addInMiddle(int data, int idx){
         if(idx == 0){
            addFirst(data);
            return;
         }
        Node newNode = new Node(data);
        //Tracking the size of a LL
        size++;
        Node temp = head;
        int i=0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }   
        temp.next = newNode.next;
        temp.next = newNode;
    }
    
    //Remove 1st
    public int removeFirst(){
        //Base condition
        if(size == 0){
            return -1;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){

        //corner cases
        if(size == 0){
            return -1;
        }
        if(size == 0){
            int val = head.data;
            head = tail = null;
            return val;
        }
        //real code
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }

        int val = tail.data;
        tail = prev;
        size--;
        return val;
    }


    //Search in LL
    public int searchKey(int key){  // TC = 0(n)
        Node temp = head;
        int i = 0;
        while(temp != null){
             if(temp.data == key){
                return i;
             }
             temp = temp.next;
        }
        return -1;
    }

    //Search key using Recursion
    public int helper(Node head, int key){
        //Base Case
        if(head == null){
            return -1;
        }
        //Bcoz head's idx = 0 always
        if(head.data == key){
            return 0;
        }

       int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
     
        return idx+1;
    }

    public int recSearch(int key){
       return  helper(head, key);
    }

    //⭐⭐⭐
    //Reverse a LL
    public static void reverseLL(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
          head = prev;
}


//⭐⭐⭐
//Remove nth Node from End
public static void removeNthFromEnd(int n){
       
    // ➡️Calculate size 
    int size = 0;
    Node temp = head;
    while(temp != null){
        temp = temp.next;
        size++;
    }

    if(n == size){ //Means n is the " head " Node
       head = head.next;
       return;
    }
    
    int runLoopTill = size-n;
    int runLoopFrom = 1;
    Node prev = head;
    while(runLoopFrom < runLoopTill){
          prev = prev.next;
          runLoopFrom++;
    }
    //(size-n)+1
    prev.next = prev.next.next;
    return;
}


public static Node findMid(Node head){
           Node slow = head;
           Node fast = head;
           while(fast.next != null && fast != null){
            slow = slow.next;
            fast = fast.next.next;
           }
           return slow;
    }

//IsPalinDrome 
public static boolean IsPalinDrome() {

    if(head == null || head.next == null){
        return true;
    }

    //step 1 = find mid
    Node midNode = findMid(head);
    //step 2 = reverse 2nd half
    Node prev = null;
    Node curr =  midNode;
    Node next;
    while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = prev;
    }
    Node right = prev;
    Node left = head;
//step 3 = compare 1st and 2nd half
    while(right != null){
         if(left.data != right.data){
            return false;
         }
         left = left.next;
         right = right.next;
    }
    return true;
}


//Linked List = Part = 2️⃣

//Detecting a cycle in LL
public static boolean isCycle(){
    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;

        if(slow == fast){
            return true;//Cycle exists
        }
    }
    return false;//Cycle dosen't exist
}

//Remove a cycle from LL
public static void removeCycle(){
    //1 = detect cycle 
    Node slow = head;
    Node fast = head;
    boolean cycle = false;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            cycle = true;
            break;
        }
        if(cycle == false){
            return;
        }
    }

    //2 = find meeting point
    slow = head;
    Node prev = null;
    while(slow != fast){
        prev = fast;
        slow = slow.next;
        fast = fast.next;
    }
    //remove cycle -> last.next = null
    prev.next = null;
}

//GetMid Fuction

private static Node getMid(Node head){
       Node slow = head;
       Node fast = head;

       while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
       }
       return slow; //slow is mid node
}

//Merge Function

private static Node merge(Node head1, Node head2){
       
     Node mergeLL = new Node(-1);
     Node temp = mergeLL;

     while(head2 != null && head2.next != null){
           if(head1.data <= head2.data){
             temp.next = head1;
             head1 = head1.next;
             temp = temp.next;
           }
           else{
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
           }
     }

     while(head1 != null){
        temp.next = head1;
        head1 = head1.next;
        temp = temp.next;
     }

     while(head2 != null){
        temp.next = head2;
        head2 = head2.next;
        temp = temp.next;
     }
     return mergeLL.next; //As first elm is dummy var
}
//Merge Sort in LL
public static Node mergeSortLL(Node head){

    //Base cases
    if(head != null || head.next == null){
        return head;
    }

    //1️⃣ find mid
    Node mid = getMid(head);

    //2️⃣left and right merge sorting
     Node rightHead = mid.next;
     mid.next = null;
     Node left = mergeSortLL(head);
     Node right = mergeSortLL(rightHead);

     //3️⃣Merge left and right in ascending order
     return merge(left, right);
}

//Zigzag Linked List

public static void zigZag(){
    //1
    //find mid
    Node slow = head;
    Node fast = head.next;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    Node mid = slow;

    //2
    //Reverse the 2nd half
    Node curr = mid.next;
    mid.next = null;
    Node prev = null;
    Node next;
    while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    //3
    //Alternate Merging
    Node left = head;
    Node right = prev;
    Node nextL, nextR;
    while(left != null && right != null){
        nextL = left.next;
        left.next = right;
        nextR = right.next;
        right.next = nextL;
        left = nextL;
        right = nextR;
    }
}












    public static void main(String args[]){
        LinkedList li = new LinkedList();
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(4);
        // head.next.next.next = temp;

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());
        
        // li.addFirst(1);
        // li.addFirst(2);
        // li.addFirst(3);
        // li.addFirst(4);
        // li.addFirst(5);
        // li.addFirst(6);

        // printLL();
        // li.head = mergeSortLL(li.head);
        // printLL();


        li.addLast(1);
        li.addLast(2);
        li.addLast(3);
        li.addLast(4);
        li.addLast(5);

        printLL();
        zigZag();
        printLL();
    }
}