public class LastOcuurence {
    
    public static int lastOccurence(int arr[], int i, int key){
            //Base Case
            if(i == arr.length){
                return -1;
            }
            //Work
            int isFound = lastOccurence(arr, i+1, key);
            if(isFound == -1 && arr[i]==key){
                return i;
            }
            return isFound;
    }

    public static void main(String args[]){
        int arr[] = {2,5,6,7,3,9,2,7};
        System.out.println(lastOccurence(arr, 0, 7));
    }
}
