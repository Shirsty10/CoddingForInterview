package com.shirsty.data.structure.Array;

import com.shirsty.data.structure.helper.OneDimeArrayHelper;

public class OneDimenArrayQue {

    OneDimeArrayHelper helper = new OneDimeArrayHelper();

    //LeetCode -75. Sort Colors
    /*Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects
      of the same color are adjacent, with the colors in the order red, white, and blue.
      We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
      You must solve this problem without using the library's sort function.

      Example 1:
      Input: nums = [2,0,2,1,1,0]
      Output: [0,0,1,1,2,2]
     */
    public void sortColors(int[] nums) {
        int n= nums.length;

        int zero = 0;
        int one = 0;
        int two = n-1;

        while(one<=two){
            if(nums[one] == 1){
                one++;
            }else if(nums[one] == 0){
                helper.swap(nums,one,zero);
                 one++;
                 zero++;
            }else{
                helper.swap(nums, one,two);
                two--;
            }
        }
    }


}
