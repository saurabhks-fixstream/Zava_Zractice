package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {

    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] c : courses) {
            time += c[0];
            pq.add(c[0]);
            if (time > c[1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {

        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(scheduleCourse(courses));
    }
}
