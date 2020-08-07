package com.leetcode.javapractice;

public class SmallestRangeI {

    public static int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int a : A) {
            if (a <= min) {
                min = a;
            }
            if (a >= max) {
                max = a;
            }
        }
        return Math.max(0, max - min - 2 * K);
    }

    public static void main(String[] args) {

        int[] A = {1, 43, 223, 443, 22, 33, 223, 445, 4};
        System.out.println(smallestRangeI(A, 9));

    }

}
