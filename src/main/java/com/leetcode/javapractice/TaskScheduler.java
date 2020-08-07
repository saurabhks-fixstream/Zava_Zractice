package com.leetcode.javapractice;

import java.util.Arrays;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);
        int f_max = count[25];
        int idle_time = (f_max - 1) * n;
        for (int i = count.length - 2; i >= 0 && idle_time > 0; i--) {
            idle_time -= Math.min(f_max - 1, count[i]);
        }
        idle_time = Math.max(0, idle_time);
        return idle_time + tasks.length;
    }

    public static void main(String[] args) {

        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(tasks, 2));
    }
}
