import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;

 public class BtAdvance {
    
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
    
//     //Height of Tree
//     public static int heightOfTree(Node root) {
//         if(root == null) {
//             return 0;
//         }
//         int leftHeight = heightOfTree(root.left);
//         int rightHeight = heightOfTree(root.right);
//         return Math.max(leftHeight, rightHeight) + 1;
//     }

//     //Number of Nodes
//     public static int numberOfNodes(Node root) {
//         if(root == null) {
//             return 0;
//         }
//         int leftCount = numberOfNodes(root.left);
//         int rightCount = numberOfNodes(root.right);
//         return leftCount +rightCount + 1;
//     }

//     //Sum of Nodes
//     public static int sumOfNodes(Node root) {
//            if(root == null) {
//             return 0;
//            }
//            int leftSum = sumOfNodes(root.left);
//            int rightSum = sumOfNodes(root.right);
//            return leftSum + rightSum + root.data;
//     }


//     //Diameter of Tree
//     //Approach 1
//     public static int diameter(Node root) {
//         if(root == null) {
//             return 0;
//         }

//         int leftDiam = diameter(root.left);
//         int rightDiam = diameter(root.right);
//         int leftHt = heightOfTree(root.left);
//         int rightHt = heightOfTree(root.right);

//         return Math.max(Math.max(leftDiam, rightDiam), leftHt + rightHt + 1);
//     }


//     static class Info {
//         int diam;
//         int height;

//         public Info(int diam, int height) {
//             this.diam = diam;
//             this.height = height;
//         }
//     }
//     //Approach 2
//     //Diameter of Tree
//     public static Info diameter2(Node root) {

//         //Base Case 
//         if(root == null) {
//             return new Info(0, 0);
//         }

//         Info leftInfo = diameter2(root.left);
//         Info rightInfo = diameter2(root.right);

//         int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.height + rightInfo.height + 1);
//         int height = Math.max(leftInfo.height, rightInfo.height) +1;
//         return new Info(diam , height);
//     }




//     //IS SUBTREE 

//     public static boolean isSubtree(Node root, Node subRoot) {
//          //Base Case
//          if(root == null) {
//             return false;
//          }
//         if(root.data == subRoot.data) {
//             if(isIdentical(root, subRoot)) {
//                return true;
//             }
//         }
//         return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
//     }
         
//     public static boolean isIdentical(Node node, Node subRoot) {
//         if(node == null && subRoot == null) {
//             return true;
//         }
//         else if(node == null || subRoot == null || node.data != subRoot.data) {
//                return false;
//         }
//         if(!isIdentical(node.left, subRoot.left))
//         return false;

//         if(!isIdentical(node.right, subRoot.right))
//         return false;

//         return true;
//     }




    //⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐Top View Of Tree⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐


    //Info Object
    static class Infor {
         Node node;
         int hd;
         public Infor(Node node, int hd) {
            this.node = node;
            this.hd = hd;
         }
    }


    public static void topView(Node root) {
          Queue<Infor> q = new LinkedList<>();
          HashMap<Integer, Node> map = new HashMap<>();
          int min = 0, max = 0;
          q.add(new Infor(root, 0));

          while(!q.isEmpty()) {
            Infor currInfo = q.remove();
            //if null
            if(currInfo == null) {
                if(!q.isEmpty()) {
                    break;
                }
                else {
                    q.add(null);
                }
            }
            //if not null
            else {

               if(!map.containsKey(currInfo.hd)) {
                  map.put(currInfo.hd, currInfo.node);
               }

               if(currInfo.node.left != null) {
                q.add(new Infor(currInfo.node.left, currInfo.hd-1));
                min = Math.min(min, currInfo.hd-1);
               }

               if(currInfo.node.right != null) {
                  q.add(new Infor(currInfo.node.right, currInfo.hd+1));
                  max = Math.max(max, currInfo.hd+1);
               }
            }
          }

          for(int i=min; i<=max; i++) {
            System.out.print(map.get(i).data +" ");
          }
    }



    // *****************************Kth Level of a Tree**************************************
    public static void kthLevel(Node root, int level, int k) {
        //Base Case
        if(root == null) {
            return;
        }

        if(level == k) {
            System.out.println(root.data+" ");
        }
        //Recursion
        kthLevel(root.left, level+1, k);
        kthLevel(root.right, level+1, k);
    }


    //****************LCA (Lowest Common Ancestor)*****************************************
    //Approach 1
    //GetPath From root to Node
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
           //Base Case
           if(root == null){
            return false;
           }

           path.add(root);

           //Check if my root is my destination 
           if(root.data == n) {
            return true;
           }

          boolean left = getPath(root.left, n, path);
          boolean right = getPath(root.right, n, path);

          if(left || right) {
            return true;
          }
        path.remove(path.size() - 1);
        return false;

    }

    public static Node lca1(Node root, int n1, int n2) {
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);

            int i = 0;
            for(; i<path1.size() && i<path2.size(); i++) {
                if(path1.get(i) != path2.get(i)) {
                    break;
                }
            }
        Node lca = path2.get(i-1);
        return lca;
    }

    //Approach 2
    public static Node lca2(Node root, int n1, int n2) {
         //Base case
         if(root == null || root.data == n1 || root.data == n2) {
            return root;
         }

         Node leftLca = lca2(root.left, n1, n2);
         Node rightLca = lca2(root.right, n1, n2);

         //Corner Cases
         if(leftLca == null) {
            return rightLca;
         }
         if(rightLca == null) {
            return leftLca;
         }

         return root;
    }



    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

    //     // System.out.println(heightOfTree(root));
    //     // System.out.println(numberOfNodes(root));
    //     // System.out.println(sumOfNodes(root));

    //     //DIAMETER OF TREE
    //    // System.out.println(diameter(root));
    //     // System.out.println(diameter2(root).diam);
    //     // System.out.println(diameter2(root).height);

    //     // Subtree structure 
    //     Node subRoot = new Node(2);
    //     subRoot.left = new Node(4);
    //     //subRoot.right = new Node(5);

    //     System.out.println(isSubtree(root, subRoot));
    //  topView(root);


    //kthLevel(root, 0, 2);


    int n1 = 4, n2 = 5;
    System.out.println(lca1(root, n1, n2).data);
    System.out.println(lca2(root, n1, n2).data);

    }
}
