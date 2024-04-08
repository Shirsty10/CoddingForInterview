package com.shirsty.data.structure.Array;

import java.util.HashMap;
import java.util.Map;

//Two Sum based Ques and its Approaches-----
public class TwoSum {

    //LeetCode 1. Two Sum - Easy
    /*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to
    target.You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    */

    public int[] twoSum(int[] nums, int target) {
      int ans[] = new int[2];

      //Base Level Approach (Naive)-- Running nested for loop - TC - O(n*n)
       /* for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
        */

        //Using Map - TC - O(n)
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val = target-nums[i];
            if(mp.containsKey(val)){
                ans[0] = mp.get(val);
                ans[1] = i;
                return ans;
            }else{
                mp.put(nums[i],i);
            }
        }

        return ans;

    }


}
