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

    //LeetCode - 167. Two Sum II - Input Array Is Sorted

    /*Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
    find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1]
    and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
    The tests are generated such that there is exactly one solution. You may not use the same element twice.
    Your solution must use only constant extra space.

    Example 1:

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
     */

    public int[] twoSum2(int[] numbers, int target) {
        int st = 0;
        int ed = numbers.length-1;
        int[] ans = new int[2];
        while(st<ed){
            int sum = numbers[st] + numbers[ed];

            if(sum > target){
                ed--;
            }else if(sum < target){
               st++;
            }else{
                ans[0] = st+1;
                ans[1] = ed+1;
                return ans;
            }
        }
        return ans;
    }


}
