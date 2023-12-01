public class CountingSort {
        
    public static void countingSortAlgo(int arr[]){
          //finding Largest number in array
          int largest = Integer.MIN_VALUE;
          for(int i=0; i<arr.length; i++){
             largest = Math.max(largest, arr[i]);
          }
          int count[] = new int[largest+1];

          //Calculating Frequency array
          for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
          }

          //Traversing frequency array to sort the arr
          int j = 0;
          for(int i=count.length-1; i>=0; i--){
              while(count[i] > 0){
                arr[j] = i; // Making new array of sorted elements
                j++; //Increasing the index of new array
                count[i]--; // Decreasing the number of frequency array to 0 after inserting in new array
              }
          }
    }

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static void main(String args[]){
        int nums[] = {3,6,2,1,8,7,4,5,3,1};
        countingSortAlgo(nums);
        printArr(nums);
    }
}
