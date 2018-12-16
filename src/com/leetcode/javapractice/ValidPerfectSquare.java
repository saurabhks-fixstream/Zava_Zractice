package com.leetcode.javapractice;

public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        int start = 1;
        int end = num;
        while (start <= end) {
            long mid = start + ((end - start) / 2);
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                start = (int) mid + 1;
            } else {
                end = (int) mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(isPerfectSquare(104976));

    }

}
