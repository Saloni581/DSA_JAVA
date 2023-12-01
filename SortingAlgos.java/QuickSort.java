public class QuickSort {
    

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void quickSort(int arr[], int si, int ei){
           
        //Base Case
        if(si >= ei){
            return;
        }

        //find pivot index at right place
        int pivotidx = partition(arr, si, ei);
        quickSort(arr, si, pivotidx-1);  //left part
        quickSort(arr, pivotidx, ei);    //right part
    }

    public static int partition(int arr[], int si, int ei){
            
        //pivot point
        int pivot = arr[ei];
        int i = si-1; // to make places for elements smaller than pivot index

        for(int j=si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

      public static void main(String args[]){
             int a[] = {6,3,9,8,2,5};
             quickSort(a, 0, a.length-1);
             printArr(a);
      }
}
