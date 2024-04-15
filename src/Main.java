import com.shirsty.data.structure.Array.MatrixBased;
import com.shirsty.data.structure.Array.Permutation;
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

//        int []nums4 = {-1,2,1,-4};
//        int target3 = 1;
//
//        System.out.println(twoSumQue.threeSumClosest(nums4,target3));

//         int []nums5 ={1,0,-1,0,-2,2}; int target = 0;
//
//        List<List<Integer>> ans5 = twoSumQue.fourSum(nums5,target);
//        for(List<Integer> list : ans5){
//            System.out.println("Values - " +list);
//        }

        Permutation permutation = new Permutation();
//        int[] nums = {1,2,3};
//        permutation.nextPermutation(nums);
//
//        Arrays.stream(nums).forEach(System.out:: print);

//          int[] nums2 = {3,2,1};
//          permutation.prevPermOpt1(nums2);
//        Arrays.stream(nums2).forEach(System.out:: print);

        MatrixBased matrixBased = new MatrixBased();
        int matrix[][] = {{1,2,3},
                      {4,5,6},
                      {7,8,9}};

        Arrays.stream(matrix).flatMapToInt(Arrays:: stream).forEach(x-> System.out.print(x + " "));
        System.out.println();

        List<Integer> list = matrixBased.spiralOrder(matrix);
        list.stream().forEach(x-> System.out.print(x + " "));

    }
}