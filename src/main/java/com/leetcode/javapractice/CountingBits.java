package com.leetcode.javapractice;

public class CountingBits {

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] result = countBits(2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
