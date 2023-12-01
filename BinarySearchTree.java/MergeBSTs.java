import java.util.*;


public class MergeBSTs {
    

    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }



    //1
    public static void getInOrder(Node root, ArrayList<Integer> arr) {
           //base case
           if(root == null) {
            return;
           }
           getInOrder(root.left, arr);
           arr.add(root.data);
           getInOrder(root.right, arr);
    }


    //2
    public static Node balanceBSTs(ArrayList<Integer> finalArr, int st, int en) {
         //Base Case
         if(st > en) {
            return null;
         }
         //find mid
         int mid =  (st+en) / 2;
         Node root = new Node(finalArr.get(mid));
         root.left = balanceBSTs(finalArr, st, mid-1);
         root.right = balanceBSTs(finalArr, mid+1, en);
         return root;
    }


    //3
    public static Node mergeBSTs(Node root1, Node root2) {
           //step 1 = find Inorder Seq of root1
           ArrayList<Integer> arr1 = new ArrayList<>();
           getInOrder(root1, arr1);

           //step 2 = find Inroder Seq of root2
           ArrayList<Integer> arr2 = new ArrayList<>();
           getInOrder(root2, arr2);

           //step 3 = merge
           int i = 0, j = 0;
           ArrayList<Integer> finalArr = new ArrayList<>();
           while(i < arr1.size() && j < arr2.size()) {
                if(arr1.get(i) <= arr2.get(j)) {
                  finalArr.add(arr1.get(i));
                  i++;
                }
                else {
                    finalArr.add(arr2.get(j));
                    j++;
                }
           }

           while(i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
           }
           while(j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
           }

           //step 4 = balanced BSTs
           Node root = balanceBSTs(finalArr, 0, finalArr.size()-1);
           return root;
    }




    //4
    public static void preOrder(Node root) {
        //Base Case
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }




    public static void main(String args[]) {
         Node root1 = new Node(2);
         root1.left = new Node(1);
         root1.right = new Node(4);

         Node root2 = new Node(9);
         root2.left = new Node(3);
         root2.right = new Node(12);

        Node ans = mergeBSTs(root1, root2);
        preOrder(ans);
    }
}
