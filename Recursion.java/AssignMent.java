public class AssignMent{


    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //1
    //return all occurences of given key
    public static void keyOccurences(int arr[], int i,int key){
         //Base Case
         if(i == arr.length){
           return;
         }
         //Work
         if(arr[i] == key){
            System.out.println(i+" ");
         }
        keyOccurences(arr, i+1, key); 
    }


    //2
    //Convert numbers to String value = eg : 2019 = two zero one nine
    static String  digit[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void printDigits(int num){

        //Base Case
        if(num == 0){
            return;
        }
        int lastDg = num % 10;
        printDigits(num/10);
        System.out.print(digit[lastDg]+" ");
    }

    //3
    //length of a string
    public static int  strLength(String str){
          //Base case
          if(str.length() == 0){
             return 0;
          }

          //work
          return strLength(str.substring(1))+1;
    }

    //4
    //Contiguous Substrings starting and ending with same character
    public static int countSubStrings(String str, int i,int j, int n){
        //Base Case
        if(n == 1){
            return 1;
        }
        if(n <= 0){
            return 0;
        }
        int result = countSubStrings(str, i+1, j, n-1) + countSubStrings(str, i, j-1, n-1) - countSubStrings(str, i+1, j-1, n-2);

        if(str.charAt(i) == str.charAt(j)){
            result++;
        }
        return result;
    }


    //⭐//Most Important
    //Tower of hanoi

    public static void towerOfHanoi(int n, String src, String helper, String dest){
        //Base Case
        if(n == 1){
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }

        //work
        //transfer top n-1 from src to helper using dest as "helper" 
        towerOfHanoi(n-1, src, dest, helper);
        //transfer nth from src to dest 
        System.out.println("transfer disk "+n+" from "+src+" to "+helper);
        //transfer n-1 from helper to dest using src as a "helper "
        towerOfHanoi(n-1, helper,src, dest);
    }
    public static void main(String args[]){
        //1
        //   int arr[] = {2,4,5,6,37,8,3,2,3,7};
        //   keyOccurences(arr, 0, 3);

        //2
        // printDigits(23545);

        //3
        //  String str = "myNameisSaloni";
        //  System.out.println(strLength(str));

        //  //4
         String str = "abcab";
         System.out.print(countSubStrings(str, 0, str.length()-1, str.length()));

       //5
    //    int n = 3;
    //    towerOfHanoi(n, "S","H", "D");
    }

}