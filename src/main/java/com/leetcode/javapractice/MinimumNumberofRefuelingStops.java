package com.leetcode.javapractice;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberofRefuelingStops {

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        int i = 0;
        int n = stations.length;
        int stops = 0;
        int maxDistance = startFuel;
        while (maxDistance < target) {
            while (i < n && stations[i][0] <= maxDistance) {
                queue.offer(stations[i++][1]);
            }
            if (queue.isEmpty()) {
                return -1;
            }
            maxDistance += queue.poll();
            stops++;
        }
        return stops;
    }

    public static void main(String[] args) {

        int[][] stations = {};
        System.out.println(minRefuelStops(1, 1, stations));
    }
}
