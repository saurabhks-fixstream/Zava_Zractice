package com.leetcode.javapractice;

public class TeemoAttacking {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int time = duration;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            time += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return time;
    }

    public static void main(String[] args) {

        int[] timeSeries = {1, 4};
        System.out.println(findPoisonedDuration(timeSeries, 2));
    }
}
