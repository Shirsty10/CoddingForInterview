package com.shirsty.data.structure.Array.IntervalBased;

import com.shirsty.data.structure.helper.OneDimeArrayHelper;

import java.util.Arrays;
import java.util.HashMap;

public class IntervalOverlap {

    OneDimeArrayHelper helper = new OneDimeArrayHelper();

    //Leetcode-452. Minimum Number of Arrows to Burst Balloons
     /*There are some spherical balloons taped onto a flat wall that represents the XY-plane.
     The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a
     balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates
     of the balloons.
     Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
     A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the
     number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
     Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

      Example 1:

        Input: points = [[10,16],[2,8],[1,6],[7,12]]
        Output: 2
        Explanation: The balloons can be burst by 2 arrows:
        - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
        - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].

      */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a, b) ->Integer.compare(a[0], b[0]));  //sorting with comparator
        // Arrays.sort(points, (a, b) -> {
        //     if (a[0] == b[0]) {
        //         return Integer.compare(a[1], b[1]);
        //     }
        //     return Integer.compare(a[0], b[0]);
        // });
        int count =1;
        int prev[] = points[0];
        for(int i=1;i<points.length;i++){
            int prevSt= prev[0];
            int prevEd=prev[1];
            int curSt = points[i][0];
            int curEd = points[i][1];

            if(prevEd<curSt){     //no overlapping
                count++;
                prev = points[i];
            }else{     //overlapping
                prev[0] = Math.max(prevSt,curSt);
                prev[1] = Math.min(prevEd,curEd);
            }
        }
        return count;
    }

    //LeetCode-435. Non-overlapping Intervals
    /*Given an array of intervals where intervals[i] = [starti, endi], return the
    minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

    Example 1:
    Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
    Output: 1
    Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // Arrays.sort(intervals, (a,b)-> a[0]-b[0]);   //sorting on the basis of st point will not work
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int[] prevInterval = intervals[0];
        int count=0;

        for(int i=1;i<intervals.length;i++){
            int curSt = intervals[i][0];
            int cusrEd = intervals[i][1];
            int prevSt = prevInterval[0];
            int prevEd = prevInterval[1];

            if(prevEd> curSt){  //overlapping
                count++;
            }else{
                prevInterval = intervals[i];
            }

        }
        return count;
    }

    //LeetCode - 436. Find Right Interval
    /*You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
        The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
         Note that i may equal j.
        Return an array of right interval indices for each interval i. If no right interval exists for interval i,
        then put -1 at index i.

        Example 2:
        Input: intervals = [[3,4],[2,3],[1,2]]
        Output: [-1,0,1]
        Explanation: There is no right interval for [3,4].
        The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
        The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
     */
    public int[] findRightInterval(int[][] intervals) {
        int n= intervals.length;
        int[] starts = new int[n];
        int[] ans = new int[n];
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<n;i++){
            starts[i] = intervals[i][0];
            mp.put(intervals[i][0],i);
        }

        Arrays.sort(starts);

        for(int i=0;i<n;i++){
            int element = helper.binarySearchLargerAlmost(starts,intervals[i][1],n);

            if(element == -1){
                ans[i] = -1;
            }else{
                ans[i] = mp.get(starts[element]);
            }
        }
        return ans;

    }
}


