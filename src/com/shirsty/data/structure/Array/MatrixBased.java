package com.shirsty.data.structure.Array;

import java.util.ArrayList;
import java.util.List;

public class MatrixBased {

    //LeetCode - 54. Spiral Matrix
    /*Given an m x n matrix, return all elements of the matrix in spiral order.
    Example 1:
     Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     Output: [1,2,3,6,9,8,7,4,5]
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int m= matrix.length; //row
        int n= matrix[0].length; //col

        int dir =0;  //(dir = 0 -> left to right, dir =1 -> top to down, dir = 2 -> right to left, dir = 3 -> down to up)

        int top = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;

                while(top<=down && left <=right){

                    if(dir >3)
                        dir =0;

                    if(dir ==0){
                       //from left to right
                        for(int i=left ;i<=right;i++){
                            list.add(matrix[top][i]);
                        }
                        top++;

                    }
                    if(dir == 1){
                        //from top to down
                        for(int i=top ;i<=down;i++){
                            list.add(matrix[i][right]);
                        }
                        right--;

                    }
                    if(dir==2){
                        //from right to left
                        for(int i=right ;i>=left;i--){
                            list.add(matrix[down][i]);
                        }
                        down--;
                    }
                    if(dir == 3){
                        //from down to top
                        for(int i=down ;i>=top;i--){
                            list.add(matrix[i][left]);
                        }
                        left++;
                    }
                    dir++;
                }

        return list;
    }
}
