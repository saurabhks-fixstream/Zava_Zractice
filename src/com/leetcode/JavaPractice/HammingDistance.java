package com.leetcode.JavaPractice;

public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int arrx[] = new int[32];
        int arry[] = new int[32];
        int count = 0;
        while (x != 0) {
            arrx[count++] = x % 2;
            x /= 2;
        }
        count = 0;
        while (y != 0) {
            arry[count++] = y % 2;
            y /= 2;
        }
        count = 0;
        for (int i = 0; i < 32; i++) {
            if (arrx[i] != arry[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(hammingDistance(10, 25));

    }

}
