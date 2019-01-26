package com.leetcode.javapractice;

public class SumofSquareNumbers {

    public static boolean judgeSquareSum(int c) {
        long start = 0;
        long end = (long) Math.sqrt(c);
        while (start <= end) {
            long sum = (start * start) + (end * end);
            if (sum == c) {
                return true;
            } else if (sum < c) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(judgeSquareSum(5004));

    }

}
