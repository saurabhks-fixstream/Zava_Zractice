package com.leetcode.javapractice;

public class HappyNumber {

    public static boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int sum = 0;
        int count = 7;
        while (count >= 0) {
            if (n == 0) {
                n = sum;
                sum = 0;
                count--;
            }
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        if (sum == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(isHappy(70));

    }

}
