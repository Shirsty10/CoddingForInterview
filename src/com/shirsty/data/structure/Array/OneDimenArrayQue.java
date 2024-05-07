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

    //LeetCode - 985. Sum of Even Numbers After Queries
    /*You are given an integer array nums and an array queries where queries[i] = [vali, indexi].
      For each query i, first, apply nums[indexi] = nums[indexi] + vali, then print the sum of the even values of nums.
      Return an integer array answer where answer[i] is the answer to the ith query.

      Example 1:
      Input: nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
      Output: [8,6,2,4]
      Explanation: At the beginning, the array is [1,2,3,4].
      After adding 1 to nums[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
      After adding -3 to nums[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
      After adding -4 to nums[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
      After adding 2 to nums[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.

     */
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

        int evnsum = 0;
        for(int num : nums){
            if(num%2 ==0) evnsum+=num;
        }
        int res[] = new int[nums.length];
        for(int i=0;i<queries.length;i++){
            int val = queries[i][0];
            int idx = queries[i][1];
            if(nums[idx] %2 ==0){
                evnsum-=nums[idx];
            }

            nums[idx]+=val;

            if(nums[idx] %2 ==0){
                evnsum+=nums[idx];
            }
            res[i] = evnsum;
        }
        return res;
    }


}
