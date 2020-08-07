package com.leetcode.javapractice;

import java.util.Arrays;

public class NextGreaterElementIII {

    public static int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int i;
        int j;
        for (i = digits.length - 1; i > 0; i--) {
            if (digits[i - 1] < digits[i]) {
                break;
            }
        }
        if (i == 0) {
            return -1;
        }
        int x = digits[i - 1];
        int index = i;
        for (j = i + 1; j < digits.length; j++) {
            if (digits[j] > x && digits[j] <= digits[index]) {
                index = j;
            }
        }
        char temp = digits[i - 1];
        digits[i - 1] = digits[index];
        digits[index] = temp;
        Arrays.sort(digits, i, digits.length);
        long val = Long.valueOf(new String(digits));
        return val <= Integer.MAX_VALUE ? (int) val : -1;
    }

    public static void main(String[] args) {

        System.out.println(nextGreaterElement(12));
    }
}
