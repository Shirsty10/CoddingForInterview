package com.shirsty.data.structure.Array;

import java.util.*;

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

     //LeetCode - 15. 3Sum
    /*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
    such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.

    Example 1:

    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation:
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.
    */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<n-2;i++){

            if(i>0 && nums[i]== nums[i-1]) continue;
            twoSumHelper(nums,i+1,n-1,res,nums[i]);

        }
        return res;
    }

    private void twoSumHelper(int[] nums,int st, int ed, List<List<Integer>> res,int target ){
        while(st<ed){

            while(st<ed && nums[st] ==nums[st+1]){
                st++;
            }
            while(st<ed && nums[ed] == nums[ed-1]){
                ed--;
            }

            int sum = nums[st]+nums[ed];
            if(sum == -target){
                List<Integer> temp = new ArrayList<>();
                temp.add(target);
                temp.add(nums[st]);
                temp.add(nums[ed]);

                res.add(temp);
            }

            st++;
            ed--;
        }
    }

     //LeetCode -16. 3Sum Closest
    /*Given an integer array nums of length n and an integer target,
    find three integers in nums such that the sum is closest to target.
     Return the sum of the three integers.
     You may assume that each input would have exactly one solution.

     Example 1:
     Input: nums = [-1,2,1,-4], target = 1
     Output: 2
     Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int clSum = Integer.MAX_VALUE;

      for(int i=0;i<n-2;i++){
          int st = i+1;
          int ed = n-1;

          while(st<ed){
            int currSum = nums[st]+nums[ed]+ nums[i];

            if(Math.abs(currSum-target)<Math.abs(target-clSum)){
              clSum = currSum;
            }
            if(currSum<target){
                st++;
            }else{
                ed--;
            }

          }
      }
      return clSum;
    }

    //LeetCode - 18. 4Sum
    /*Given an array nums of n integers, return an array of
     all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     0 <= a, b, c, d < n a, b, c, and d are distinct.
     nums[a] + nums[b] + nums[c] + nums[d] == target
     You may return the answer in any order.

     Example 1:
     Input: nums = [1,0,-1,0,-2,2], target = 0
     Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     */

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0;i<n-3;i++){
            if(i==0  || ( i>0 && nums[i] != nums[i-1])){
                for(int j=i+1;j<n-2;j++){
                    if(j==i+1 || (j>i+1 && nums[j]!=nums[j-1])){
                        int st = j+1;
                        int ed = n-1;
                        int sum = nums[i] + nums[j];
                        int val = target- sum;

                        while(st<ed) {

                            if(nums[st] + nums[ed] <val){
                                st++;
                            }else if(nums[st] + nums[ed] >val){
                                ed--;
                            }else{
                                res.add(Arrays.asList(nums[i],nums[j],nums[st],nums[ed]));
                                while(st<ed && nums[st]==nums[st+1])
                                    st++;
                                while(st<ed && nums[ed]==nums[ed-1])
                                    ed--;

                                st++;
                                ed--;
                            }

                        }

                    }
                }
            }
        }

        return res;
    }

    //LeetCode - 454. 4Sum II -- We'll be doing this using Map - In Map folder

}
