package com.leetcode.javapractice;

public class MaximizeDistancetoClosestPerson {

    public static int maxDistToClosest(int[] seats) {
        int result = 0;
        int n = seats.length;
        int last = -1;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                result = last < 0 ? i : Math.max(result, (i - last) / 2);
                last = i;
            }
        }
        result = Math.max(result, n - last - 1);
        return result;
    }

    public static void main(String[] args) {

        int[] seats = {1, 0, 0, 0, 1, 0, 1};
        System.out.println(maxDistToClosest(seats));
    }
}
