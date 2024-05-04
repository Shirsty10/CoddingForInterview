package com.shirsty.data.structure.helper;

public class ArrayHelper {
    public void transpose(int[][] matrix) {
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
    public void reverse(int[][] matrix){
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
