package com.leetcode.javapractice;

public class FindPermutation {

    public static int[] findPermutation(String s) {
        int[] result = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            result[i] = i + 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                int l = i;
                while (i < s.length() && s.charAt(i) == 'D') {
                    i++;
                }
                reverse(result, l, i);
            }
        }
        return result;
    }

    private static void reverse(int[] arr, int l, int h) {
        while (l < h) {
            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
            l++;
            h--;
        }
    }

    public static void main(String[] args) {

        int[] result = findPermutation("I");
        for (int i : result) {
            System.out.print(i + ",");
        }
    }
}
