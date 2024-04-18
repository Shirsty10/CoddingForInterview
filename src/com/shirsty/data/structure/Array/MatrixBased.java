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

    //Leetcode - 48. Rotate Image
    /*You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

      You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
      DO NOT allocate another 2D matrix and do the rotation.

      Example 1:

      Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
      Output: [[7,4,1],[8,5,2],[9,6,3]]

     */
    public void rotate(int[][] matrix) {

      //transpose+reverse
        transpose(matrix);
        reverse(matrix);
    }

    private void transpose(int[][] matrix) {
        for(int row=0; row<matrix.length; row++){
            for(int col=row+1; col<matrix[0].length; col++){
                if(row!=col){
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = temp;
                }
            }
        }
    }
    private void reverse(int[][] matrix){
      for(int row =0;row<matrix.length;row++){
          int st = 0;
          int ed = matrix[row].length-1;
          while(st<ed){
              int temp = matrix[row][st];
              matrix[row][st] = matrix[row][ed];
              matrix[row][ed] = temp;

              st++;
              ed--;
          }
      }
    }

    
}
