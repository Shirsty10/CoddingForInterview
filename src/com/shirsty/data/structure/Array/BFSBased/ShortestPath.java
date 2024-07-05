package com.shirsty.data.structure.Array.BFSBased;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    //LeetCode - 1091. Shortest Path in Binary Matrix
    /*Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
    If there is no clear path, return -1.

    A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell
    (i.e., (n - 1, n - 1)) such that:
    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share
    an edge or a corner).
    The length of a clear path is the number of visited cells of this path.
     */
    int n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        n= grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1]== 1) return -1;

        int ans = Integer.MAX_VALUE;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0));
        int steps =1;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int times=0;times<sz;times++){
                Pair p = q.poll();
                int row = p.row;
                int col = p.col;

                if(row == n-1 && col == n-1){
                    return steps;
                }

                for(int i=-1;i<=1;i++){
                    for(int j=-1;j<=1;j++){
                        int nr = row + i;
                        int nc = col + j;

                        if(nr>=0 && nr < n && nc>=0 && nc <n && grid[nr][nc] ==0){
                            grid[nr][nc] = 1;
                            q.offer(new Pair(nr,nc));
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
