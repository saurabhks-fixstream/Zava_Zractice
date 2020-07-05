package com.leetcode.javapractice;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {

    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + d != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] arr = { 3, 5, 1 };
        System.out.println(canMakeArithmeticProgression(arr));

    }

}
