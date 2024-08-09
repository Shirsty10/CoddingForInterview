package com.shirsty.data.structure.DP;

import java.util.Arrays;


public class EasyDPWithLoop {

    int[] dp;
    //LeetCode - 377. Combination Sum IV
    /*Given an array of distinct integers nums and a target integer target, return the number of possible combinations
       that add up to target.

        The test cases are generated so that the answer can fit in a 32-bit integer.

        Example 1:
        Input: nums = [1,2,3], target = 4
        Output: 7
        Explanation:
        The possible combination ways are:
        (1, 1, 1, 1)
        (1, 1, 2)
        (1, 2, 1)
        (1, 3)
        (2, 1, 1)
        (2, 2)
        (3, 1)
        Note that different sequences are counted as different combinations.
     */
    public int combinationSum4(int[] nums, int target) {
        dp=new int[target+1];
        Arrays.fill(dp,-1);
        return helper(nums, target, target);
    }

    private int helper(int[] nums,int target, int val){
        if(val< 0) return 0;

        if(val ==0){
            return 1;
        }
        if(dp[val] != -1){
            return dp[val];
        }
        int count=0; //use a local variable for count
        for(int i=0;i<nums.length;i++){
            count+=helper(nums,target, val-nums[i]);
        }
        return dp[val] =count;
    }
}
