import java.util.*;
//Modified it according to situation
public class FloodFillAlgo {

    //TC => 0(n*m);
    //Implementation of "Implicit Graph"
    public void helper(int[][] image, int sr, int sc, int col, boolean vis[][], int orgCol) {
          //Corner Cases || Base Cases
          if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
          }
          image[sr][sc] = orgCol;

          //left
          helper(image, sr, sc-1, col, vis, orgCol);
          //right
          helper(image, sr, sc+1, col, vis, orgCol);
          //up
          helper(image, sr-1, sc, col, vis, orgCol);
          //down
          helper(image, sr+1, sc, col, vis, orgCol);
    }

    public int[][] floodFillAlgo(int[][] image, int sr, int sc, int col) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, col, vis, col);
        return image;
    }
    public static void main(String args[]) {

    }
}
