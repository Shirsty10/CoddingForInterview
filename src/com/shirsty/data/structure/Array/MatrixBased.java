package com.shirsty.data.structure.Array;

import java.util.*;

import com.shirsty.data.structure.helper.ArrayHelper;

public class MatrixBased {

    ArrayHelper helper = new ArrayHelper();

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
        helper.transpose(matrix);
        helper.reverse(matrix);
    }

    //LeetCode - 498. Diagonal Traverse
    /*Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
      Example 1:
      Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
       Output: [1,2,4,7,5,3,6,8,9]

     */
    public int[] findDiagonalOrder(int[][] mat) {
        int n= mat.length;
        int m=mat[0].length;
        int [] res = new int[n*m];
        int idx =0;
        boolean up =true;

        int i=0,j=0;

        while(i<n && j<m){
            if(up==true){
                while(i>0 && j<m-1){
                    res[idx++] = mat[i][j];
                    i--;
                    j++;
                }
                res[idx++] = mat[i][j];
                if(j==m-1){
                    i++;
                }else{
                    j++;
                }

            }else{
                while(i<n-1 && j>0){
                    res[idx++] = mat[i][j];
                    i++;
                    j--;
                }
                res[idx++] = mat[i][j];
                if(i==n-1){
                    j++;
                }else{
                    i++;
                }

            }
            up=!up;
        }
        return res;
    }

    //LeetCode- 1329. Sort the Matrix Diagonally
    /*A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row
    or leftmost column and going in the bottom-right direction until reaching the matrix's end.
    For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix,
    includes cells mat[2][0], mat[3][1], and mat[4][2].
    Given an m x n matrix mat of integers, sort each matrix diagonal in ascending
    order and return the resulting matrix.

    Example 1:
    Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
    Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
     */
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m= mat[0].length;

        HashMap<Integer,ArrayList<Integer>> mp = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!mp.containsKey(i-j)){
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(mat[i][j]);
                    mp.put((i-j), l);
                }else{
                    ArrayList<Integer> l = mp.get(i-j);
                    l.add(mat[i][j]);
                    mp.put((i-j),l);
                }

            }
        }

        for(Map.Entry<Integer,ArrayList<Integer>> entry : mp.entrySet()){
            Collections.sort(entry.getValue());
        }



        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                ArrayList<Integer> list = mp.get(i-j);
                mat[i][j] = list.get(list.size()-1);
                list.remove(list.size()-1);
            }
        }

        return mat;

    }


}
