import com.shirsty.data.structure.Array.TwoSum;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");

        TwoSum twoSumQue = new TwoSum();
//        int []nums = {2,7,11,15};
//        int target = 9;
//        int ans[] = twoSumQue.twoSum(nums,target);
//
//        System.out.println("[" + ans[0] + "," + ans[1] + "]");
//
//        int num2[] = {2,7,11,15}; int target2 = 9;
//        int ans2[] = twoSumQue.twoSum2(nums,target);
//
//        System.out.println("[" + ans2[0] + "," + ans2[1] + "]");
//
//        int []nums3 = {-1,0,1,2,-1,-4};
//
//        List<List<Integer>> ans3 = twoSumQue.threeSum(nums3);
//        for(List<Integer> list : ans3){
//            System.out.println(list);
//        }

        int []nums4 = {-1,2,1,-4};
        int target3 = 1;

        System.out.println(twoSumQue.threeSumClosest(nums4,target3));
    }
}