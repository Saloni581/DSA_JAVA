import java.util.Arrays;
import java.util.Collections;
public class InbuiltSort {
    
    public static void printArr(Integer arr[]){
        for(int i=0;i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        Integer nums[] = {3,6,2,1,8,7,4,5,3,1};
        Arrays.sort(nums);
        printArr(nums);
        Arrays.sort(nums,3, 6);
        printArr(nums);
        Arrays.sort(nums, Collections.reverseOrder());
        printArr(nums);
        Arrays.sort(nums,3,6, Collections.reverseOrder());
        printArr(nums);
    }
}
