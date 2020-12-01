package com.leetcode.javapractice;

public class JumpGameIII {

    public static boolean canReach(int[] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] >= 0) {
            if (arr[start] == 0) {
                return true;
            }
            arr[start] = -arr[start];
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        System.out.println(canReach(arr, 5));
    }
}
