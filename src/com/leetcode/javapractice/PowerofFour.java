package com.leetcode.javapractice;

public class PowerofFour {

    public static boolean isPowerOfFour(int num) {
        if (num < 1) {
            return false;
        }
        while (num > 1) {
            if (num % 4 == 0) {
                num /= 4;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPowerOfFour(6499));

    }

}
