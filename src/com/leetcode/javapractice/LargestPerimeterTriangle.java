package com.leetcode.javapractice;

import java.util.Arrays;

public class LargestPerimeterTriangle {

    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int perimeter = 0;
        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                int sum = A[i] + A[i + 1] + A[i + 2];
                if (sum >= perimeter) {
                    perimeter = sum;
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {

        int[] A = { 2, 1, 2 };
        System.out.println(largestPerimeter(A));

    }

}
