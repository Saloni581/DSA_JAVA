import java.util.*;
public class Basics{


    //DECREASING ORDER
    public static void printDeceasing(int n){
          //Base Case
           if(n == 0){
             return; 
           }
          //Work
          System.out.println(n + " ");
          //Recursion
          printDeceasing(n-1);
         
    }

//INCREASING ORDER
    public static void printInceasing(int n){
          //Base Case
           if(n == 0){
             return; 
           }
          //Recursion
          printInceasing(n-1);
          //Work
          System.out.print(n + " ");
    }


//FACTORIAL
    public static int factorial(int n){
           //Base Case
            if(n == 0){
                return 1;
            }
           //Work - //Recursion
           return  n*factorial(n-1);
    }



//SUM OF N NUMBERS
    public static int sumOf(int n){
        //   //Base Case
          if(n == 1){
             return 1;
          }

          //Recursion
          return  n + sumOf(n-1);


          //2nd Method
          //return n*(n+1)/2;
    }


    //FIBONACCI SEQUENCE
    public static int fibonacci(int n){
           if(n == 0 || n == 1){
             return n;
           }
           //Recursion
           return fibonacci(n-1)+fibonacci(n-2);
    }



    //CHECK IF ARR IS SORTED OR NOT
    public static boolean isSorted(int arr[], int i){
      //Base Case
      if(i == arr.length-1){
        return true;
      }
      //Recursion
      if(arr[i] > arr[i+1]){
        return false;
      }
      return isSorted(arr, i+1);
    }


    
    //MAIN
    public static void main(String args[]){
          //  int n = 12;
          //  printDeceasing(n);
          //  printInceasing(n);
          //  System.out.println();
          //  System.out.println("Factorial of the Number n is : "+factorial(4));
          //  System.out.println("sum of n natural number is : "+sumOf(5));
            System.out.println(fibonacci(1000));

          //  int arr[] = {1,2,3,4,5};
          //  int arr1[] = {2,3,1,5,4,7,8,4};
          //  System.out.println(isSorted(arr, 0));
          //  System.out.println(isSorted(arr1, 0));
    }
}