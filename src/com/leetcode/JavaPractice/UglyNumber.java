package com.leetcode.JavaPractice;

public class UglyNumber {

    public static boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        if (num == 0) {
            return false;
        }
        boolean ugly = true;
        while (num != 1) {
            if (num % 5 != 0 && num % 3 != 0 && num % 2 != 0 && num != 1) {
                ugly = false;
                break;
            } else {
                if (num % 5 == 0) {
                    num /= 5;
                }
                if (num % 3 == 0) {
                    num /= 3;
                }
                if (num % 2 == 0) {
                    num /= 2;
                }
            }
        }
        return ugly;
    }

    public static void main(String[] args) {

        System.out.println(isUgly(8));
        System.out.println(isUgly(14));
        System.out.println(isUgly(0));

    }

}
