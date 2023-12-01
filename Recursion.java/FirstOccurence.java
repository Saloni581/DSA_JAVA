public class FirstOccurence {
    
    public static int firstOccurence(int arr[],int i, int key){
        //Base Case
        if(i == arr.length){
            return -1;
        }


        //Work
        if((arr[i]) == key){
            return i;
        }
        //Recursion
        return firstOccurence(arr, i+1, key);
    }

    public static void main(String args[]){
           int arr[] = {2,5,6,7,3,9,2,7};
           System.out.println(firstOccurence(arr, 0, 7));
    }
}
