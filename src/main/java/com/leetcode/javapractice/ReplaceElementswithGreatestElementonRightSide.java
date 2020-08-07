package com.leetcode.javapractice;

public class ReplaceElementswithGreatestElementonRightSide {

    public static int[] replaceElements(int[] arr) {
        if (arr.length == 0 || null == arr) {
            return arr;
        }
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int prevMax = max;
            if (arr[i] >= max) {
                max = arr[i];
            }
            arr[i] = prevMax;
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {17, 18, 5, 4, 6, 1};
        replaceElements(arr);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
