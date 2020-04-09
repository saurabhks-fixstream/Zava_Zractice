package com.leetcode.javapractice;

public class CountingElements {

    public static int countElements(int[] arr) {
        int[] count = new int[1001];
        for (int i : arr) {
            count[i]++;
        }
        int result = 0;
        for (int i : arr) {
            if (i < 1000 && count[i] > 0 && count[i + 1] > 0) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };
        System.out.println(countElements(arr));

    }

}
