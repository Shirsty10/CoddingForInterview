package com.shirsty.data.structure.helper;

public class OneDimeArrayHelper {

    public void swap(int [] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int binarySearchSmallerAlmost(int[] nums, int trg,int n){
        int st = 0;
        int ed = n-1;
        int ans =-1;

        while(st<=ed){
            int mid = st+(ed-st)/2;

            if(nums[mid]<=trg){
                ans = mid;
                st=mid+1;
            }else{
                ed=mid-1;
            }
        }
        return ans+1;
    }

    public int binarySearchLargerAlmost(int[] nums, int trg,int n){
        int st = 0;
        int ed = n-1;
        int ans =-1;

        while(st<=ed){
            int mid = st+(ed-st)/2;

            if(nums[mid]==trg){
                return mid;
            }else if(nums[mid] > trg){
                ans = mid;
                ed=mid-1;
            }else{
                st = mid+1;
            }
        }
        return ans;
    }
}
