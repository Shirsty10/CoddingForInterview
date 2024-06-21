package com.shirsty.data.structure.Array.DFSBased;

public class IslandBased {

    //LeetCode - 200 -Number of Islands
    /*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.

    Example 1:

    Input: grid = [
            ["1","1","1","1","0"],
            ["1","1","0","1","0"],
            ["1","1","0","0","0"],
            ["0","0","0","0","0"]
            ]
    Output: 1
     */
    int n=0,m=0;
    private void dfs(char[][] grid,int r,int c){

        if(r<0 || r>=n || c<0 || c>=m || grid[r][c] =='0'){
            return;
        }

        grid[r][c] ='0';

        dfs(grid,r,c-1);  //left
        dfs(grid,r-1,c);  //up
        dfs(grid,r,c+1); // right
        dfs(grid,r+1,c); //down

    }

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }
}
