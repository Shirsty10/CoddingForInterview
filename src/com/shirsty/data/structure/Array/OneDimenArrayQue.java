package com.shirsty.data.structure.Array;

import com.shirsty.data.structure.helper.OneDimeArrayHelper;

import java.util.Arrays;
import java.util.HashMap;

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

    //LeetCode -334. Increasing Triplet Subsequence
    /*Given an integer array nums, return true if there exists a triple of indices (i, j, k)
    such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

      Example 1:
      Input: nums = [1,2,3,4,5]
      Output: true
      Explanation: Any triplet where i < j < k is valid.
     */
    public boolean increasingTriplet(int[] nums) {
        int num1 =Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;

        int num3;

        for(int i=0;i<nums.length;i++){
            num3 = nums[i];

            if(num3<=num1){
                num1 = num3;
            }else if(num3<=num2){
                num2 = num3;
            }else{
                return true;
            }
        }
        return false;
    }

    //LeetCode- 523. Continuous Subarray Sum
    /*Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
      A good subarray is a subarray where:

        its length is at least two, and
        the sum of the elements of the subarray is a multiple of k.
        Note that:
        A subarray is a contiguous part of the array.
        An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

        Example 1:
        Input: nums = [23,2,4,6,7], k = 6
        Output: true
        Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.

     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;

        HashMap<Integer,Integer> mp = new HashMap<>();
        int sum=0;
        mp.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int reminder = sum%k;

            if(mp.containsKey(reminder)){
                if(Math.abs(i-mp.get(reminder))>=2)
                    return true;
            }else{
                mp.put(reminder,i);
            }
        }
        return false;
    }

    //LeetCode- 2389. Longest Subsequence With Limited Sum
    /* You are given an integer array nums of length n, and an integer array queries of length m.
       Return an array answer of length m where answer[i] is the maximum size of a subsequence that you
       can take from nums such that the sum of its elements is less than or equal to queries[i].

       A subsequence is an array that can be derived from another array by deleting some or no elements
       without changing the order of the remaining elements.

      Example 1:

        Input: nums = [4,5,2,1], queries = [3,10,21]
        Output: [2,3,4]
        Explanation: We answer the queries as follows:
                    - The subsequence [2,1] has a sum less than or equal to 3. It can be proven
                    that 2 is the maximum size of such a subsequence, so answer[0] = 2.
                    - The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven
                    that 3 is the maximum size of such a subsequence, so answer[1] = 3.
                    - The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven
                    that 4 is the maximum size of such a subsequence, so answer[2] = 4.
     */

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        int ans[] =new int[m];

        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i]+nums[i-1];
        }

        for(int i=0;i<queries.length;i++){
            int val = helper.binarySearchSmallerAlmost(nums,queries[i],n);
            ans[i] = val;
        }
        return ans;
    }

    //LeetCode - 283. Move Zeroes
    /*Given an integer array nums, move all 0's to the end of it while maintaining the relative order
     of the non-zero elements.
        Note that you must do this in-place without making a copy of the array.

        Example 1:
        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        int n=nums.length;

        if(n==1) return;

        int l=0;
        int r =1;
        while(l<n && r <n){
            if(nums[l] ==0 && nums[r] !=0){
                helper.swap(nums,l,r);
                l++;
                r++;
            }else if(nums[l] !=0 && nums[r] ==0){
                l=r;
                r++;
            }else{
                r++;
            }
        }

    }

}
