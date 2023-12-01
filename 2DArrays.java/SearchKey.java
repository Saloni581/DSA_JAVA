import java.util.*;
public class SearchKey{


    public static boolean searchKey(int mat[][], int key){
         for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == key){
                   System.out.print("Key found at "+ i + "," +j);
                   return true;
                }
            }
         }
         return false;
    }
    public static void main(String args[]){

        //Basics
        int matrix[][] = new int[3][3];
        int n = matrix.length, m = matrix[0].length;

        Scanner sc = new Scanner(System.in);
        //Input
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        //Output
         for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    
        searchKey(matrix, 5);

        //    int matrix[][] = {{2,3,5},{6,1,8}};
        //    int key = 5;
        //    searchKey(matrix, key);


    }
}