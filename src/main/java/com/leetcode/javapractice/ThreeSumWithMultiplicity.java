package com.leetcode.javapractice;

public class ThreeSumWithMultiplicity {

    public static int threeSumMulti(int[] arr, int target) {
        long[] c = new long[101];
        for (int a : arr) {
            c[a]++;
        }
        long res = 0;
        for (int i = 0; i <= 100; i++)
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) {
                    continue;
                }
                if (i == j && j == k) {
                    res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                } else if (i == j && j != k) {
                    res += c[i] * (c[i] - 1) / 2 * c[k];
                } else if (j < k) {
                    res += c[i] * c[j] * c[k];
                }
            }
        return (int) (res % (1e9 + 7));
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(threeSumMulti(arr, 8));
    }
}
