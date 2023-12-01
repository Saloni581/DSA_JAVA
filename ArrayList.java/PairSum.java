import java.util.ArrayList;

public class PairSum{
     
    //Brute Force
    public static boolean pairSumBF(ArrayList<Integer> list, int target){
             
          for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++){
                if(list.get(i)+list.get(j) == target){
                    return true;
                }
            }
          }
          return false;
    }

    //2 Pointer Approach
    public static boolean pairSum1(ArrayList<Integer> list, int target){
          
         int lp = 0, rp = list.size()-1;
         if(target == 1){
            return false;
         }
         while(lp != rp){
            if(list.get(lp)+list.get(rp) == target){
                return true;
            }
            if(list.get(lp)+list.get(rp) < target){
                lp++;
            }
            else{
                rp--;
            }
         }
         return false;
    }

    //Pair sum 2

    public static boolean pairSum2(ArrayList<Integer> list, int target){
           int pivot = -1;
           int n = list.size();
           for(int i=0;i<list.size(); i++){
            if(list.get(i) > list.get(i+1)){
               pivot = i;
               break;
            }
           }
           int lp = pivot+1;
           int rp = pivot;
           while(lp != rp){
            if(list.get(lp)+list.get(rp) < target){
                lp = (lp+1) % n;
            }
            else{
                rp = (n+rp-1) % n;
            } if(list.get(lp)+list.get(rp) == target){
                return true;
            }
           }
           return false;
        }


    public static void main(String args[]){
            
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.add(6);
        // list.add(7);
        // list.add(8);
        // list.add(9);

        // int tar = 7;
        // System.out.println(pairSumBF(list, tar));
        // System.out.println(pairSum1(list, tar));

        //For Pair Sum 2 Problem

        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int tar = 16;
        System.out.println(pairSum2(list, tar));
    }
}