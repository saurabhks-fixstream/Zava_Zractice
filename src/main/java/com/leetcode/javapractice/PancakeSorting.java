package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {

    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = A.length, j; i > 0; i--) {
            for (j = 0; A[j] != i; j++) ;
            reverse(A, j + 1);
            result.add(j + 1);
            reverse(A, i);
            result.add(i);
        }
        return result;
    }

    private static void reverse(int[] A, int i) {
        int start = 0;
        int end = i - 1;
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] A = {3, 2, 4, 1};
        System.out.println(pancakeSort(A));
    }
}
