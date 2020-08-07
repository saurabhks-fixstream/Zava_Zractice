package com.leetcode.javapractice;

public class DuplicateZeros {

    public static void duplicateZeros(int[] arr) {
        int zeros = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeros++;
            }
        }
        int length = arr.length + zeros;
        for (int i = arr.length - 1, j = length - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
            } else {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
                j--;
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }

    }

}
