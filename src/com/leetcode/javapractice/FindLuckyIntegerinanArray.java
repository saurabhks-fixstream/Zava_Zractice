package com.leetcode.javapractice;

public class FindLuckyIntegerinanArray {

    public static int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int i : arr) {
            count[i - 1]++;
        }
        for (int i = 501; i > 0; i--) {
            if (count[i - 1] == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 2, 3, 3, 3 };
        System.out.println(findLucky(arr));

    }

}
