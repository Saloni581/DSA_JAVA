import java.util.*;

public class BinarySearch{

    public static int binSearch(int arr[],int key){
        int s = 0, e = arr.length-1;
        int mid = (s+e)/2;
        while(s<=e){
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid] > key){
                e = mid-1;
            }
            else if(arr[mid] < key){
                s = mid+1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
         int a[] = {2,3,4,5,6,7,8,81};
         int key = 5;
        System.out.println("Key found at : "+binSearch(a,key));

    }
}