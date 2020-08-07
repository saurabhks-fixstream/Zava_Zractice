package com.leetcode.javapractice;

public class PerformStringShifts {

    public static String stringShift(String s, int[][] shift) {
        int n = s.length();
        int count = 0;
        for (int[] sh : shift) {
            if (sh[0] == 0) {
                count -= sh[1];
            } else {
                count += sh[1];
            }
        }
        if (count < 0) {
            s = leftrotate(s, Math.abs(count) % n);
        } else {
            s = leftrotate(s, n - (count % n));
        }
        return s;
    }

    private static String leftrotate(String str, int d) {
        String ans = str.substring(d) + str.substring(0, d);
        return ans;
    }

    public static void main(String[] args) {

        int[][] shift =
                {{1, 4}, {0, 7}, {0, 8}, {0, 7}, {0, 6}, {1, 3}, {0, 1}, {1, 7}, {0, 5}, {0, 6}};
        System.out.println(stringShift("xqgwkiqpif", shift));

    }

}
