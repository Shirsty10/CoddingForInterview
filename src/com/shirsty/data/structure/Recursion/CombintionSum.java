package com.shirsty.data.structure.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombintionSum {

    //LeetCode - 216. Combination Sum III
    /*Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
        Only numbers 1 through 9 are used.
        Each number is used at most once.
        Return a list of all possible valid combinations. The list must not contain the same combination twice,
        and the combinations may be returned in any order.

        Example 1:
        Input: k = 3, n = 7
        Output: [[1,2,4]]
        Explanation:
        1 + 2 + 4 = 7
        There are no other valid combinations.
     */

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int nums[] = {1,2,3,4,5,6,7,8,9};
        solve(k, n, 0,ans,new ArrayList(), nums );


        return ans;
    }

    private void solve(int k, int n, int curr,List<List<Integer>> ans ,List<Integer> res, int nums[]){
        if(n ==0 && res.size() == k){
            ans.add(new ArrayList<>(res));
            return;
        }
        if(res.size()>k) return;

        for(int i=curr;i<nums.length;i++){
            res.add(nums[i]);
            solve(k,n-nums[i], i+1,ans,res , nums);
            res.remove(res.size()-1);
        }


    }
}
