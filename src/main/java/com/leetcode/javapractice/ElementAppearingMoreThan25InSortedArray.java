package com.leetcode.javapractice;

public class ElementAppearingMoreThan25InSortedArray {

    public static int findSpecialInteger(int[] arr) {
        int count = 1;
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (num == arr[i]) {
                count++;
            } else {
                num = arr[i];
                count = 1;
            }
            if (count > arr.length / 4) {
                return arr[i];
            }
        }
        return num;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(findSpecialInteger(arr));
    }
}
