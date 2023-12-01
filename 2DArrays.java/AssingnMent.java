public class AssingnMent {
    
    //1
    //Print no. of 7's
    //Brute Force
    public static void printSeven(int mat[][]){
        int seven = 0;
         for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 7){
                    seven++;
                }
            }
         }
         System.out.println(seven);
    }

    //2
    //Sum of numbers present in 2nd row
    public static int rowSum(int mat[][]){
        int sum = 0;
            for(int j=0; j<mat[0].length; j++){
                sum+= mat[1][j];
            }
        return sum;
    }

    //3
    //Transpose of given matrix
    public static void transpose(int mat[][]){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                System.out.print(mat[j][i]+" ");
            }
            System.out.println();
         }
    }
    public static void main(String args[]){
        int matrix[][] = {{1,4,9},{11,4,3},{2,2,3}};
        printSeven(matrix);
        System.out.println(rowSum(matrix));
         transpose(matrix);
    }
}
