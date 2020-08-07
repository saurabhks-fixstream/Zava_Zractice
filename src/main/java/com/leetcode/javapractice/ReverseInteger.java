package com.leetcode.javapractice;

public class ReverseInteger {

    public static long power(int a, int b) {
        long result = 1;
        for (int i = 1; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public static int reverse(int x) {
        long input = x;
        int flag = 0;
        if (input < 0) {
            flag = -1;
            input = (input * -1);
        } else {
            flag = 1;
        }
        long arr[] = new long[32];
        int i = 0;
        long result = 0;
        while (input != 0) {
            arr[i++] = input % 10;
            input = input / 10;
        }
        if (arr[0] != 0) {
            result += arr[0] * power(10, i);
        }
        for (int j = 1; j < i; j++) {
            result += (arr[j] * power(10, (i - j)));
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) (result * flag);
        }
    }

    public static void main(String[] args) {

        System.out.println(reverse(-123));
    }
}
