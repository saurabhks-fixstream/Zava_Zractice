package com.leetcode.javapractice;

import java.util.Arrays;

public class SmallestRangeII {

    public static int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int ans = A[A.length - 1] - A[0];
        for (int i = 0; i < A.length - 1; i++) {
            int a = A[i];
            int b = A[i + 1];
            int high = Math.max(A[A.length - 1] - K, a + K);
            int low = Math.min(A[0] + K, b - K);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] A = {1};
        System.out.println(smallestRangeII(A, 0));
    }
}
