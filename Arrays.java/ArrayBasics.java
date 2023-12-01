import java.util.*;

public class ArrayBasics{

    public  static void main(String args[]){
        //Create 
        // int arr[]= new int[59];
        // int arr1[] = {12, 45,67};
        // int arr2[3] = {1,2,3};
        // String vowels[] = {'a', 'e', 'i','o','u'};

        //Input/Output
        int marks[] = new int[100];
        Scanner sc = new Scanner(System.in);
        marks[0] = sc.nextInt();
        marks[1] = sc.nextInt();
        marks[2] = sc.nextInt();

        System.out.println("Maths : "+marks[0]);
        System.out.println("Physics : "+marks[1]);
        System.out.println("Chemestry : "+marks[2]);

        // Indirect - updation
        marks[0] = marks[0]+1;
        System.out.println("Maths : "+marks[0]);
        
    }
}