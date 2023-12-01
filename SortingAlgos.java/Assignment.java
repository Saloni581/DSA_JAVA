import java.util.*;
public class Assignment {
    

    public static void printArr(String arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }

                 // 1️⃣
    // //sort array of string(lowercase)
     
    // public static boolean isAlphabaticallySmaller(String str1, String str2){
    //     if(str1.compareTo(str2) < 0){
    //         return true;
    //     }
    //     return false;
    // }
    //  public static String merge(String arr1[], String arr2[]){
    //     int m = arr1.length;
    //     int n = arr2.length;
    //     String temp[] = new String[m+n];
    //     int k = 0;
    //     int i = 0;
    //     int j = 0;

    //     while(i <= m && j <= n){
    //         if(isAlphabaticallySmaller(arr1[i], arr2[j])){
    //             temp[k] = arr1[i];
    //             i++;
    //             k++;
    //         }
    //         else{
    //             temp[k] = arr2[j];
    //             j++;
    //             k++;
    //         }
    //     }
 
    //     while(i <= m){
    //          temp[k++] = arr1[i++]; 
    //     }
        
    //     while(j <= n){
    //          temp[k++] = arr1[j++]; 
    //     }

    //     return temp;
    //  }
    //  public static String mergeSortStrings(String arr[], int si, int ei){
        
    //     //Base Case
    //     if(si == ei){
    //        String a[] = {arr[si]};
    //        return a;
    //     }
    //     int mid = si + (ei - si)/2;
        
    //     String arr1[] = mergeSortStrings(arr, si, mid);
    //     String arr2[] = mergeSortStrings(arr, mid+1, ei);

    //     String arr3[] = merge(arr1, arr2);
    //     return arr3;
    //  }


    



                     //2️⃣
    //majority element 

    // public static int majorityElement(int array[]){
              
    //     //📝 brute force
    //     int majorityCount = array.length/2;

    //     for(int i=0; i<array.length; i++){
    //         int count = 0;
    //         for(int j=0; j<array.length; j++){
    //             if(array[j] == array[i]){
    //                 count += 1;
    //             }
    //         }
    //         if(count > majorityCount){
    //             return array[i];
    //         }
    //     }
    //     return -1;
    // }
    //⭐ Optimized code

    private static int countInRange(int[] nums, int num, int lo, int hi){
        int count = 0;
        for(int i=lo; i<=hi; i++){
            if(nums[i] == num){
                count++;
            }
        }
        return count;
    }
    private static int majorityELementRec(int[] nums, int lo, int hi){
        if(lo == hi){
            return nums[lo];
        }
        //recurse on the left and right halves of the slice
        int mid = lo + (hi - lo)/2;
        int left = majorityELementRec(nums, lo, mid);
        int right = majorityELementRec(nums, mid+1, hi);
        
        //if the two halves agree on the majority element, then return it
        if(left == right){
            return right;
        }
        //otherwise count each element and return the "winner"
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount? left : right;
    }

    public static int majorityElement(int[] nums){
        return majorityELementRec(nums, 0, nums.length-1);
    }





                //3️⃣

    //inversion count in a array

    //Brute Force
    public static int inversionCount(int arr[]){
        int count = 0;
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                   count++;
                }
            }
        }
        return count;
    }
    

    //Optimized code = Modified merge sort
    public static int merge(int arr[], int left, int mid, int right){
        int i = left, j = mid, k= 0;
        int invCount = 0;
        int temp[] = new int[(right - left + 1)];
        while((i < mid) && (j <= right)){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                invCount += (mid-i);
                j++;
            }
            k++;
        }

        while(i < mid){
            temp[k++] = arr[i++];
        }

        while(j <= right){
        temp[k++] = arr[j++];
}

for(i = left, k = 0; i <= right; i++,k++){
    arr[i] = temp[k];
}
return invCount;
}

private static int mergeSort(int arr[],int left,int right){
    int invCount = 0;
    if(left < right){
        int mid = (right + left) / 2;

        invCount = mergeSort(arr, left, mid);
        invCount += mergeSort(arr, mid+1, right);
        invCount += merge(arr, left, mid+1,right);
    }
    return invCount;
}

 public static int getInversions(int arr[]){
        return mergeSort(arr, 0, arr.length-1);
}

    public static void main(String args[]){
        //1
        //    String arr[] = {"sun", "earth", "mars", "mercury"};
        //    String a[] = mergeSortStrings(arr, 0, arr.length-1);
        //    printArr(a);

        //2
    //     int nums[] = {2,2,1,1,1,2,2};
    //     //System.out.println(majorityElement(nums));
    //     System.out.println(inversionCount(nums));
    // }

   //3
   int arr[] = {3,5,6,7,1,9,0};
   System.out.println("Inversion Count = "+ getInversions(arr));
}
}