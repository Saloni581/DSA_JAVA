import java.util.*;
public class TrappingRainwater{
    public static int findTrappedWater(int barlevels[]){
        // Checking if barlevels > 2
//         if(barlevels.length == 1 || barlevels.length == 2){
//             return 0;
//         }
//         // Checking if array is sorted or not
//         for(int i=0; i<barlevels.length-1; i++){
//         if(barlevels[i] < barlevels[i+1] || barlevels.length-1 < barlevels/length-2){
//                 return 0;
//             }
//         }
        // Calculating leftmax boundry
        int leftmax[] = new int[barlevels.length];
        leftmax[0] = barlevels[0];
        for(int i=1; i<barlevels.length; i++){
            leftmax[i] = Math.max(barlevels[i], leftmax[i-1]);
        }

        // Calculating rightmax boundry
        int rightmax[] = new int[barlevels.length];
        rightmax[barlevels.length-1] = barlevels[barlevels.length-1];
        for(int i=barlevels.length-2; i>=0; i--){
            rightmax[i] = Math.max(barlevels[i], rightmax[i+1]);
        }
        // Calculating TrappedWater
        int TrappedWater = 0;
        for(int i=0; i<barlevels.length; i++){
            int Waterlevel = Math.min(leftmax[i], rightmax[i]);
            TrappedWater += Waterlevel - barlevels[i];
        }
        return TrappedWater;
    }


    public static void main(String args[]){
    
        int height[] = {7, 5, 6, 8, 2, 3, 0, 9};
        int Trappedwateris = findTrappedWater(height);
       System.out.println(Trappedwateris);
    }
}
