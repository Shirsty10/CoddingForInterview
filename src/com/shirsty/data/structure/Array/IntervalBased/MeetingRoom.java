package com.shirsty.data.structure.Array.IntervalBased;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom {

    class Pair{
        int ed;
        int rm;

        Pair(int ed,int rm){
            this.ed = ed;
            this.rm = rm;
        }
    }

    //LeetCode - 2402. Meeting Rooms III
    /*You are given an integer n. There are n rooms numbered from 0 to n - 1.

        You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will
        be held during the half-closed time interval [starti, endi). All the values of starti are unique.
        Meetings are allocated to rooms in the following manner:
        Each meeting will take place in the unused room with the lowest number.
        If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should
         have the same duration as the original meeting.
        When a room becomes unused, meetings that have an earlier original start time should be given the room.
        Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the
        lowest number.
        A half-closed interval [a, b) is the interval between a and b including a and not including b.

        Example 1:

        Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
        Output: 0
        Explanation:
        - At time 0, both rooms are not being used. The first meeting starts in room 0.
        - At time 1, only room 1 is not being used. The second meeting starts in room 1.
        - At time 2, both rooms are being used. The third meeting is delayed.
        - At time 3, both rooms are being used. The fourth meeting is delayed.
        - At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
        - At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
        Both rooms 0 and 1 held 2 meetings, so we return 0.

     */
    public int mostBooked(int n, int[][] meetings) {
        int []roomUsed = new int[n];
        PriorityQueue<Pair> meetingQueue = new PriorityQueue<>((a, b) ->{
            if(a.ed == b.ed){
                return a.rm - b.rm;
            }
            return a.ed - b.ed;
        });

        Queue<Integer> avaRooms = new PriorityQueue<>((a, b) -> a-b);

        for(int i=0;i<n;i++){
            avaRooms.add(i);
        }
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for(int i=0;i<meetings.length;i++){
            int start = meetings[i][0];
            int end = meetings[i][1];
            int duration = end-start;

            while(!meetingQueue.isEmpty() && start>= meetingQueue.peek().ed){
                Pair p = meetingQueue.poll();
                avaRooms.add(p.rm);
            }

            if(!avaRooms.isEmpty()){
                int room = avaRooms.poll();
                meetingQueue.add(new Pair(end,room));
                roomUsed[room]++;

            }else{
                Pair p = meetingQueue.poll();
                meetingQueue.add(new Pair(p.ed+ duration,p.rm));
                roomUsed[p.rm]++;
            }
        }

        int mx =-1;
        int res =0;
        for(int i=0;i<roomUsed.length;i++){
            if(mx<roomUsed[i]){
                mx = roomUsed[i];
                res = i;
            }
        }
        return res;



    }
}
