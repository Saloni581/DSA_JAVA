public class QsearchElm {
       
    public static int searchInSortedAndRotatedArray(int arr[], int tar, int si, int ei){
        //Base Case
        if(si > ei){
            return -1;
        }
        //Mid
        int mid = si+ (ei-si)/2; // can be written as (si+ei)/2

        //Best Case
        if(arr[mid] == tar){
            return mid;
        }
        //case 1
        if(arr[si] <= arr[mid]){
            //case a : left
            if(arr[si] <= tar && tar <= arr[mid]){
                return searchInSortedAndRotatedArray(arr, tar, si, mid-1);
            }else{
                //case b : right
                searchInSortedAndRotatedArray(arr, tar, mid+1, ei);
            }
        }
        else{
            if(arr[mid] <= tar && tar <=arr[ei])  //case c
                return searchInSortedAndRotatedArray(arr, tar, mid+1, ei);
            else//case d
                return searchInSortedAndRotatedArray(arr, tar, si, mid-1);
        }
    }
    public static void main(String args[]){
        int arr[] = {4,5,6,7,0,1,2};
        int target = 2;
        int tarIdx = searchInSortedAndRotatedArray(arr, target, 0, arr.length-1);
        System.out.println(tarIdx);
    }
}
