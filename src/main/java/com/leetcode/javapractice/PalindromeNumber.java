package com.leetcode.javapractice;

public class PalindromeNumber {

    public static int digitAt(int num, int place) {
        int digit = 0;
        while (place != 0) {
            digit = num % 10;
            num /= 10;
            place--;
        }
        return digit;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = x;
        int length = 0;
        int count = 0;
        while (y != 0) {
            length++;
            y /= 10;
        }
        for (int i = length; i > 0; i--) {
            if (digitAt(x, i) == digitAt(x, (length - i + 1))) {
                count++;
            }
        }
        if (count == length) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome(1356931));
    }
}
