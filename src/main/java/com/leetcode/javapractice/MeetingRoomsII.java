package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));
        int rooms = 0;
        for (int i = 0; i < intervals.length; i++) {
            while (!pq.isEmpty() && pq.peek()[1] <= intervals[i][0]) {
                pq.poll();
            }
            pq.offer(intervals[i]);
            rooms = Math.max(rooms, pq.size());
        }
        return rooms;
    }

    public static void main(String[] args) {

        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(intervals));
    }
}
