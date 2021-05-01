package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingScheduler {

    public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        int j = 0;
        int m = slots1.length;
        int n = slots2.length;
        while (i < m && j < n) {
            int intersectStart = Math.max(slots1[i][0], slots2[j][0]);
            int intersectEnd = Math.min(slots1[i][1], slots2[j][1]);
            if (intersectEnd - intersectStart >= duration) {
                return Arrays.asList(intersectStart, intersectStart + duration);
            }
            if (slots1[i][1] < slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return new ArrayList<Integer>();
    }

    public static void main(String[] args) {

        int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slots2 = {{0, 15}, {60, 70}};
        System.out.println(minAvailableDuration(slots1, slots2, 8));
    }
}
