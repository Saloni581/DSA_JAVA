class Solution {
    
    public static void dfs(char[][] grid, int i, int j) {
        //Edge Cases || Base Conditions 
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] =='0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j); // up
        dfs(grid, i-1, j); //down
        dfs(grid, i, j+1); //left
        dfs(grid, i, j-1); //right
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
}