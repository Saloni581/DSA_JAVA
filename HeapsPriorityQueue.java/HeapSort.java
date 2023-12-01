import java.util.*;

public class HeapSort {
    
    public static void heapify(int arr[], int i, int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;
        if(left < size && arr[maxIdx] < arr[left]) {
            maxIdx = left;
        }

        if(right < size && arr[maxIdx] < arr[right]) {
            maxIdx = right;
        }

        if(maxIdx != i) {
            //swap
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
            heapify(arr, maxIdx, size);  
        }
    }

    public static void heapSort(int arr[]) {
        //step 1 = to create MaxHeap
        int n = arr.length;
        for(int i=n/2; i>=0; i--) {
            heapify(arr, i, n);
        }

        //step 2 = sorting 
        for(int i=n-1; i>=0; i--) {
            //swap (largest(first) with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }

    }
    public static void main(String args[]) {
         int arr[] = {4,2,6,7,9};
         heapSort(arr);

         for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
         }
         System.out.println();
    }
}
