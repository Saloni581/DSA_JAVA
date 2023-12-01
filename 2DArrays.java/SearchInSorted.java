public class SearchInSorted {
    
    //From top right special index
    public static boolean isPresent(int mat[][], int key){
           int row = 0, col = mat[0].length-1;
           while(row < mat.length && col >= 0){
                if(mat[row][col] == key){
                    System.out.println("Key found at "+ row +","+col);
                    return true;
                }
                else if(key < mat[row][col]){
                    col--;
                }
                else{
                    row++;
                }
           }
           return false;
    }

    //From bottom left special index
    public static boolean isKeyPresent(int mat[][], int key){
        int row = mat.length-1, col = 0;
        while(row >= 0 && col < mat[0].length){
            if(mat[row][col] == key){
                System.out.println("Key found at "+ row +","+col);
                return true;
            }
            else if(key < mat[row][col]){
                row--;
            }
            else{
                col++;
            }
        }
        return false;
    }
    public static void main(String args[]){
           int matrix[][] = {{2,3,4,5},{1,2,7,9}};
        //    isPresent(matrix, 9);
        isKeyPresent(matrix, 4);
    }
}
