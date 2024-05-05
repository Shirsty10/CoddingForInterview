package com.shirsty.data.structure.helper;

public class OneDimeArrayHelper {

    public void swap(int [] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
