import com.shirsty.data.structure.Array.DFSBased.IslandBased;
import com.shirsty.data.structure.Array.IntervalBased.IntervalOverlap;
import com.shirsty.data.structure.Array.MatrixBased;
import com.shirsty.data.structure.Array.OneDimenArrayQue;
import com.shirsty.data.structure.Array.Permutation;
import com.shirsty.data.structure.Array.TwoSum;
import com.shirsty.data.structure.String.Anangram;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");
//---------------------------Two Sum Que------------------------------------------------------------------
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

 // ------------------------Permutation Que---------------------------------------------------
        Permutation permutation = new Permutation();
//        int[] nums = {1,2,3};
//        permutation.nextPermutation(nums);
//
//        Arrays.stream(nums).forEach(System.out:: print);

//          int[] nums2 = {3,2,1};
//          permutation.prevPermOpt1(nums2);
//        Arrays.stream(nums2).forEach(System.out:: print);

//------------------------Anagram Based Que-------------------------------------------------

        Anangram anangram = new Anangram();
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
//
//        List<List<String>> list = anangram.groupAnagrams(strs);

        // Extrass---- The flatMap function combines a map and a flat operation.
        //  Flattening means converting something
        // like [ [1,2,3],[4,5,6,7],[8,9] ] to [ 1,2,3,4,5,6,7,8,9 ] i.e. converting a 2D array to a 1D array.

//        list.stream()
//                .map(String::valueOf)
//                .collect(Collectors.toList())
//                .stream().forEach(System.out::println);
//
//        System.out.println("-------------------");
//
//        list.stream()
//                .flatMap(List:: stream)
//                .forEach(System.out::println);

//-------------------------------Matrix Based Ques---------------------------------------------------------

        MatrixBased matrixBased = new MatrixBased();
//        int matrix[][] = {{1,2,3},
//                      {4,5,6},
//                      {7,8,9}};
//
//        Arrays.stream(matrix).flatMapToInt(Arrays:: stream).forEach(x-> System.out.print(x + " "));

//        System.out.println();
//
//        List<Integer> list = matrixBased.spiralOrder(matrix);
//        list.stream().forEach(x-> System.out.print(x + " "));

        int matrix2[][] = {{1,2,3},
                      {4,5,6},
                      {7,8,9}};
//         matrixBased.rotate(matrix2);
//        Arrays.stream(matrix2)
//        .flatMapToInt(Arrays:: stream)
//        .forEach(x-> System.out.print(x + " "));

//        int matrix3[][] = {{1,2,3},
//                {4,5,6},
//                {7,8,9}};
//        int res[]  =matrixBased.findDiagonalOrder(matrix3);
//        Arrays.stream(res).forEach(x-> System.out.print(x + " "));

//        int matrix3[][] = {{3,3,1,1},
//                          {2,2,1,2},
//                          {1,1,1,2}};
//
//        int res[][] = matrixBased.diagonalSort(matrix3);
//        Arrays.stream(res).flatMapToInt(Arrays:: stream).forEach(x -> System.out.print(x+" "));

 //--------------------------One Dimentional Array Que---------------------------------------------------

        OneDimenArrayQue oneDQue = new OneDimenArrayQue();
//        int nums[] = {2,0,2,1,1,0};
//        oneDQue.sortColors(nums);
//        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));

//        int nums[] = {1,2,3,4};
//        int[][] queries = {{1,0},
//                           {-3,1},
//                           {-4,0},
//                            {2,3}};
//
//        int res[] =oneDQue.sumEvenAfterQueries(nums,queries);
//        Arrays.stream(res).forEach(x-> System.out.print(x+ " "));

//        int nums[] = {1,2,3,4,5};
//         System.out.println("Increasing Triplet Subsequence - " + oneDQue.increasingTriplet(nums));

//        int []nums = {23,2,4,6,7};
//        int k = 6;
//         System.out.println("Continuous Subarray sum found - " + oneDQue.checkSubarraySum(nums,k));

//        int nums[] = {4,5,2,1}, queries[] = {3,10,21};
//        int res[] =oneDQue.answerQueries(nums,queries);
//        Arrays.stream(res).forEach(x-> System.out.print(x+ " "));

//------------------------------------Interval Baes Question ---------------------------------------------------------

        IntervalOverlap intervalOverlap = new IntervalOverlap();
//        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
//         System.out.println("Min Arrows to Burst all balloons - " + intervalOverlap.findMinArrowShots(points));

//        int[][] points = {{1,2},{2,3},{3,4},{1,3}};
//        System.out.println("Min removals - "+ intervalOverlap.eraseOverlapIntervals(points));

//        int[][] intervals = {{3,4},{2,3},{1,2}};
//        int ans[] = intervalOverlap.findRightInterval(intervals);
//
//        Arrays.stream(ans).forEach(i-> System.out.print(i+ " "));

//       int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
//        int[][]secondList = {{1,5},{8,12},{15,24},{25,26}};
//        int ans[][] = intervalOverlap.intervalIntersection(firstList,secondList);
//
//        Arrays.stream(ans).forEach(row->System.out.print(Arrays.toString(row) + " "));

 //------------------------------------DFS Based Question-------------------------------------------------------------

        IslandBased islandQue = new IslandBased();
        char [][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
       System.out.println("Number of Islands - " + islandQue.numIslands(grid));

    }
}