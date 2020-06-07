package com.leetcode.javapractice;

import java.util.Arrays;

public class ThekStrongestValuesinanArray {

    public static int[] getStrongest(int[] arr, int k) {
        int[] result = new int[k];
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        int p = 0;
        int m = arr[(arr.length - 1) / 2];
        while (p < k) {
            if (Math.abs(arr[i] - m) > Math.abs(arr[j] - m)) {
                result[p++] = arr[i++];
            } else {
                result[p++] = arr[j--];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] result = getStrongest(arr, 2);
        for (int i : result) {
            System.out.print(i + ",");
        }

    }

}
