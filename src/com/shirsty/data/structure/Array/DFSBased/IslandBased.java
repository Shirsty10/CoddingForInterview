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

    //Leetcode - 1254 Number of Closed Islands
    /* Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected
    group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

        Return the number of closed islands.

        Example 1:

        Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
        Output: 2
        Explanation:
        Islands in gray are closed because they are completely surrounded by water (group of 1s).
     */

    public boolean dfs2(int[][] grid,int r,int c){
        if(r<0 || r>=n || c<0 || c>=m){
            return false;
        }

        if(grid[r][c] == 1) return true;

        grid[r][c] = 1;

        boolean left = dfs2(grid, r,c-1);
        boolean right = dfs2(grid,r,c+1);
        boolean up = dfs2(grid, r-1,c);
        boolean down = dfs2(grid, r+1,c);

        return left && right && up && down;

    }
    public int closedIsland(int[][] grid) {
        n= grid.length;
        m= grid[0].length;
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] ==0){
                    if(dfs2(grid,i,j)){
                        count++;
                    }
                }
            }
        }
        return count;

    }
}
