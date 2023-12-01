import java.util.*;
import java.util.ArrayList;

public class AdvanceBST {
    
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    //preOrder Function
    public static void preOrder(Node root) {
         if(root == null) {
            return;
         }
        System.out.print(root.data +" ");
        preOrder(root.left);
        preOrder(root.right);
    }


    //Sorted BST to Balanced BST
    public static Node balancedBST(int arr[], int st, int en) {
        //Base Case
        if(st > en) {
           return null;
        }
        int mid = (st + en)/2;
        Node root = new Node(arr[mid]);
        root.left = balancedBST(arr, st, mid-1);
        root.right = balancedBST(arr, mid+1, en);
        return root;
    }



    //inOrder Seq of My UnBalnced BST
    public static void modifiedInorder(Node root, ArrayList<Integer> InOrder) {
        if(root == null) {
            return;
        } 
        modifiedInorder(root.left, InOrder);
        InOrder.add(root.data);
        modifiedInorder(root.right, InOrder);
    }

    public static Node balancedHelper(ArrayList<Integer> inOrder, int st, int en) {
        //find mid
        if(st > en) {
            return null;
        }
        int mid = (st + en) / 2;
        Node root = new Node(inOrder.get(mid));
        root.left = balancedHelper(inOrder, st, mid-1);
        root.right = balancedHelper(inOrder, mid+1, en);
        return root;
    }
    public static Node balancedBST_2(Node root) {
        //step 1
        //get InOrder Sorted Sequence
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        modifiedInorder(root, inOrder);

        //step 2
        //Sorted BST -> Balnced BST
        root = balancedHelper(inOrder, 0, inOrder.size()-1);
        return root;
    }
    public static void main(String args[]) {
        //  int arr[] = {3,5,6,8,10,11,12};
        //  Node  root = balancedBST(arr, 0, arr.length-1);
        //  preOrder(root);

        Node root = new Node(8);
        root.left  = new Node(6);
        root.right = new Node(10);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
 
        root = balancedBST_2(root);
        preOrder(root);
    }
}
