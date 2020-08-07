package com.leetcode.javapractice;

public class LastMomentBeforeAllAntsFallOutofaPlank {

    public static int getLastMoment(int n, int[] left, int[] right) {
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < left.length; i++) {
            last = Math.max(last, left[i]);
        }
        for (int i = 0; i < right.length; i++) {
            last = Math.max(last, n - right[i]);
        }
        return last;
    }

    public static void main(String[] args) {

        int[] left = {4, 3};
        int[] right = {0, 1};
        System.out.println(getLastMoment(4, left, right));

    }

}
