import com.shirsty.data.structure.Array.TwoSum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");

        TwoSum twoSumQue = new TwoSum();
        int []nums = {2,7,11,15};
        int target = 9;
        int ans[] = twoSumQue.twoSum(nums,target);

        System.out.println("[" + ans[0] + "," + ans[1] + "]");
    }
}