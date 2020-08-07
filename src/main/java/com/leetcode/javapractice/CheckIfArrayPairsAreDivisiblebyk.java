package com.leetcode.javapractice;

public class CheckIfArrayPairsAreDivisiblebyk {

    public static boolean canArrange(int[] arr, int k) {
        int[] remainder = new int[k];
        for (int i : arr) {
            remainder[Math.floorMod(i, k)]++;
        }
        if (remainder[0] % 2 == 1) {
            return false;
        }
        for (int i = 1; i < k; i++) {
            if (remainder[i] != remainder[k - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        System.out.println(canArrange(arr, 5));
    }
}
