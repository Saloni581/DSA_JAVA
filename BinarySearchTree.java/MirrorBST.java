public class MirrorBST {
    
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    //Mirror BST Code 
    public static Node mirrorBST(Node root) {
        //Base Case 
        if(root == null) {
            return null;
        }
        Node leftS = mirrorBST(root.left);
        Node rightS = mirrorBST(root.right);
        root.left = rightS;
        root.right  = leftS;
        return root;
    }

    //preOrder Function
    public static void preOrder(Node root) {
          if(root == null) {
            return;
          }
          System.out.print(root.data+" ");
          preOrder(root.left);
          preOrder(root.right);
    }
    public static void main(String args[]) {

        /*             8
                      / \
                     5   10
                    / \    \
                   3   6    11
                   GIVEN BST
        */
            Node root = new Node(8);
            root.left = new Node(5);
            root.right = new Node(10);
            root.left.left = new Node(3);
            root.left.right = new Node(6);
            root.right.right = new Node(11);

            /*           8
                       /   \
                      10    5
                     /     /  \
                    11    6    3
                    MIRROR BST             
             */
             preOrder(root);
             System.out.println();
             root = mirrorBST(root);
             preOrder(root);
    }
}
