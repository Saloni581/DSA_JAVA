public class DiagonalSum {
    
    //Brute Force
    public static void diagonalSum(int mat[][]){
           int sum = 0;
           for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if((i==j) || (i+j) == mat.length-1){
                    sum+= mat[i][j];
                }
            }
           }
           System.out.println(sum+" ");
    }

    //Optimised Solution
     public static void optimisedSum(int mat[][]){
        int sum = 0;
        for(int i=0; i<mat.length; i++){
            sum += mat[i][i];
            //for resist to repeat the sum of overlapping element
            if(i != mat.length-1-i)
            sum += mat[i][mat.length-1-i];
        }
        System.out.println(sum+" ");
     }
     
    public static void main(String args[]){
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        diagonalSum(matrix);
        optimisedSum(matrix);
    }
}
