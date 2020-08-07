package com.leetcode.javapractice;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {

    public static int largestSumAfterKNegations(int[] A, int K) {
        int negative = 0;
        for (int a : A) {
            if (a < 0) {
                negative++;
            }
        }
        Arrays.sort(A);
        int i = 0;
        while (i < A.length) {
            if (A[i] < 0 && K > 0 && negative > 0) {
                A[i] = -A[i];
                negative--;
            } else if (K >= 0 && negative <= 0) {
                if (K % 2 == 0) {
                    break;
                } else {
                    if (i > 0 && A[i - 1] < A[i]) {
                        A[i - 1] = -A[i - 1];
                    } else {
                        A[i] = -A[i];
                    }
                }
            }
            i++;
            K--;
        }
        return Arrays.stream(A).sum();
    }

    public static void main(String[] args) {

        int[] A = {-8, 3, -5, -3, -5, -2};
        int K = 6;
        System.out.println(largestSumAfterKNegations(A, K));
    }
}
