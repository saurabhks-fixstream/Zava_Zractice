package com.leetcode.javapractice;

public class MinimumSwapstoGroupAll1sTogether {

    public static int minSwaps(int[] data) {
        if (data.length < 3) {
            return 0;
        }
        int n = 0;
        for (int num : data) {
            if (num == 1) {
                n++;
            }
        }
        int i = 0;
        int j = 0;
        int c = 0;
        int max = 0;
        while (j < data.length) {
            while (j < data.length && j - i < n) {
                if (data[j++] == 1) {
                    c++;
                }
            }
            max = Math.max(c, max);
            if (j == data.length) {
                break;
            }
            if (data[i++] == 1) {
                c--;
            }
        }
        return n - max;
    }

    public static void main(String[] args) {

        int[] data = {1, 0, 1, 0, 1};
        System.out.println(minSwaps(data));
    }
}
