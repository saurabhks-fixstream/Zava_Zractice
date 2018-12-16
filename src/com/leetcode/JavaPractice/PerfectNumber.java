package com.leetcode.JavaPractice;

public class PerfectNumber {

    public static boolean checkPerfectNumber(int num) {
        if (num % 2 != 0 || num == 0) {
            return false;
        }
        int sum = 0;
        int divisor = 1;
        while ((divisor * divisor) < num) {
            if (num % divisor == 0) {
                sum += divisor;
                if (divisor * divisor != num) {
                    sum += num / divisor;
                }
            }
            divisor++;
        }
        sum -= num;
        if (sum == num) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(checkPerfectNumber(28));

    }

}
