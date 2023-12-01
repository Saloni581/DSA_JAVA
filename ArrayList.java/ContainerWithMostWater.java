import java.util.*;
import java.util.ArrayList;
public class ContainerWithMostWater {

    // public static int storeWater(ArrayList<Integer> height){
    //     // int maxWater = 0;
    //     // //Brute Force - Time Complexity = O(n^2)
    //     // for(int i=0; i<height.size(); i++){
    //     //     for(int j=i+1; j<height.size(); j++){
    //     //         int ht = Math.min(height.get(i), height.get(j));
    //     //         int width = j-i;
    //     //         int currWater = ht*width;
    //     //         maxWater = Math.max(currWater, maxWater);
    //     //     }
    //     // }
    //     // return maxWater;
    // }


    // 2 Pointer Approach = Time Complexity = O(n)
    public static int storeMaxWater(ArrayList<Integer> height){
        int max = 0, lp = 0, rp = height.size()-1;
        while(lp < rp){
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp-lp;
            int currWater = ht*width;
            max = Math.max(currWater, max);
            if(height.get(lp) < height.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }
        return max;
        }
       public static void main(String args[]){
       
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println( storeMaxWater(height));
       }
}
