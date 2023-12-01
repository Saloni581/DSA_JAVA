import java.util.*;
public class Assignment {
//1
//Search in sorted and rotated array
public static int bSearch(int arr[], int key){
       int low = 0, high = arr.length-1;
       while(low <= high){
          int mid = low + (high-low)/2;
          if(arr[mid] == key)
          return mid;
          //When left part is sorted
          if(arr[low] < arr[mid]){
            if(key >= arr[low] && key < arr[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
          }
          //When right part is sorted
          else{
            if(key > arr[mid] && key <= arr[high]){
                low = mid+1;
            }else{
                high = mid-1;
            }
          }
       }
       return -1;
}

//2
//Duplicate in an array
public static boolean duplicate(int arr[]){
       HashSet<Integer> set = new HashSet<>();
       for(int i=0; i<arr.length; i++){
           if(set.contains(arr[i])){
            return true;
           }     
           else{
            set.add(arr[i]);
           }
       }
       return false;
}

//3
//Triplets Sum
public static int tripletSum(int arr[]){
    Arrays.sort(arr);
    for(int i=0; i<arr.length; i++){
        int l = i+1;
        int r = arr.length-1;
        while(l < r){
            int sum = arr[i] + arr[l] + arr[r];
            if(sum == 0){
                 System.out.println("["+arr[i]+","+arr[l]+","+arr[r]+"]");
                 return 1;
            }
            else if(sum < 0){
                l++;
            }
            else{
                r--;
            }
        }
    }
    return -1;
}
    public static void main(String args[]){
        //    int nums[] = {4,5,6,7,0,1,2};
        //    int key = 2;
        //    System.out.println("Key exists at index : "+bSearch(nums, key));
        
        // int nums[] = {1,2,3,4,2};
        // System.out.println(duplicate(nums));

        int nums[] = {-1,0,1,2,-1,-4};
        System.out.println(tripletSum(nums));
    }
}