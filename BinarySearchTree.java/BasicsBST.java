import java.util.*;

public class BasicsBST {

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
        public static Node buildBST(Node root, int val) {

            //Base Case 
            if(root == null) {
                return new Node(val);
            }

            if(root.data > val) {
                root.left = buildBST(root.left, val);
            }
            else {
                root.right = buildBST(root.right, val);
            }
            return root;
        }
    
    //InOrder Traversal 
    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }


    //Serch in Binary Search Tree
    public static boolean searchInBst(Node root, int key) {
        //Base Case
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(root.data < key) {
           return searchInBst(root.right, key);
        }
        else {
            return searchInBst(root.left, key);
        }
    }



    //Delete Node From BST

    public static Node findInOrderSuccessor(Node root) {
            while(root.left != null) {
                  root = root.left;
            }
            return root;
    }

    public static Node delete(Node root, int val) {
          if(root.data < val) {
            root.right = delete(root.right, val);
          }
          else if(root.data > val) {
            root.left = delete(root.left, val);
          }
          else {
            //CHECK ALL CASES HERE
            //CASE 1
            if(root.left == null && root.right == null) {
                return null;
            }
            //Case 2
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            //Case 3
            //Find InOrder Successor first
            Node InOrderS = findInOrderSuccessor(root.right);
            root.data = InOrderS.data;
            root.right = delete(root.right, InOrderS.data);
          }
          return root;
    }





    //Print in Range
    public static void printInRange(Node root, int k1, int k2) {
        //Base Case
        if(root ==  null) {
            return;
        }
        if(root.data >= k1 && root.data <= k2) {
           printInRange(root.left, k1, k2);
           System.out.print(root.data+" ");
           printInRange(root.right, k1, k2);
        }
        else if(root.data < k1) {
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }
    




    //Print Path btw root to leaf
    public static void printPath(ArrayList<Integer> path) {
          for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i)+"->");
          }
          System.out.println("Null");
    }
    public static void root2Leaf(Node root, ArrayList<Integer> path) {
        //Base Case
        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) {
            printPath(path);
        }
        root2Leaf(root.left, path);
        root2Leaf(root.right, path);
        //remove after printing the paths
        path.remove(path.size()-1);
    }


    //Is Valid BST
    public static boolean isValidBST(Node root, Node min, Node max) {
          if(root == null) {
            return true;    //An empty tree is always a valid BST
          }

          //Check Min Condition
          if(min != null && root.data <= min.data) {
             return false;
          }
          //Check Max Condition
          else if(max != null && root.data >= max.data) {
            return false;
          }
          //If both subtree (left and right) return true then return true otherwise false
          return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }



    public static void main(String args[]) {
        //int value[] = {5, 1, 3, 4, 2, 7};
        //int value[] = {6,7,2,3,11,8,9,10,12,1,4,5};
        int value[] = {22,22,22};
        Node root = null;
         for(int i=0; i<value.length; i++) {
             root = buildBST(root, value[i]);
         }
        inOrder(root);
        // System.out.println();

        // System.out.println(searchInBst(root, 15));
        // System.out.println(searchInBst(root, 10));

        // delete(root, 9);
        System.out.println();
        // inOrder(root);
        // System.out.println();
        // printInRange(root, 5, 12);
        //root2Leaf(root, new ArrayList<>());
        if(isValidBST(root, null, null)) {
            System.out.println("valid");
        }
        else {
            System.out.println("Not Valid");
        }
    }
}
