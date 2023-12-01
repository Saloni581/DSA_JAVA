import java.util.*;
import java.util.Queue;

public class MinDistance {

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
    

    //Minimum Distance Between 2 Nodes

    //1 function 
    public static Node lca(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
           return root;
        }
        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        if(leftLca == null) {
            return rightLca;
        }
        if(rightLca == null) {
            return leftLca;
        }
        return root;
    }

    public static int lcaDis(Node root, int n) {
        if(root == null) {
            return -1;
        }
        if(root.data == n) {
            return 0;
        }
        int leftDis = lcaDis(root.left, n);
        int rightDis = lcaDis(root.right, n);

        if(leftDis == -1 && rightDis == -1) {
            return -1;
        }
        else if(leftDis == -1) {
            return rightDis+1;
        }
        else {
            return leftDis+1;
        }
    }

    public static int minDistance(Node root, int n1, int n2) {
        //Node lca = lca(root, n1, n2);
        int dis1 = lcaDis(root, n1);
        int dis2 = lcaDis(root, n2);
        return dis1+dis2;
    }



    //SumTree 
    public static int sumTree(Node root) {
        if(root == null) {
            return 0;
        }
        int leftChild = sumTree(root.left);
        int rightChild = sumTree(root.right);
        
        int newLeft = root.left == null? 0: root.left.data;
        int newRight = root.right == null? 0: root.right.data;
        int data = root.data;
        root.data = newLeft + leftChild + newRight + rightChild;
        return data;
    }


    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");    
        preOrder(root.left);
        preOrder(root.right);
    }



    }


    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // int n1 = 2, n2 = 3;
        // System.out.println(minDistance(root, n1, n2));


        sumTree(root);
        preOrder(root);
       

    }
}
