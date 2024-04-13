package com.shirsty.data.structure.Array;

public class Permutation {

    //LeetCode - 31. Next Permutation
    /* A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
      For example, for arr = [1,2,3], the following are all the permutations of
      arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].

      The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
       More formally, if all the permutations of the array are sorted in one container according to their
       lexicographical order, then the next permutation of that array is the permutation that follows it in the
       sorted container. If such arrangement is not possible, the array must be rearranged as the
       lowest possible order (i.e., sorted in ascending order).

      For example, the next permutation of arr = [1,2,3] is [1,3,2].
      Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
      While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
      Given an array of integers nums, find the next permutation of nums.
      The replacement must be in place and use only constant extra memory.

      Example 1:
      Input: nums = [1,2,3]
      Output: [1,3,2]

     */

    public void nextPermutation(int[] nums) {
        int n=nums.length;

        int i=n-1;
        while(nums[i]<nums[i-1]){   //finding element which is less than its previous one
            i--;
        }
        i=i-1;
        if(i!=-1){
            int j=n-1;

            while(nums[i]>nums[j]){  // finding just greater element that ith element
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1, n-1);
    }

    private void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int st,int ed){
        while(st<ed){
            swap(nums,st,ed);
            st++;
            ed--;
        }
    }

}
