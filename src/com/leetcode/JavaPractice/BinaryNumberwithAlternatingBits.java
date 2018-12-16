package com.leetcode.JavaPractice;

public class BinaryNumberwithAlternatingBits {

    public static boolean hasAlternatingBits(int n) {
        String s = "";
        while (n > 0) {
            int rem = n % 2;
            s = rem + s;
            n /= 2;
        }
        int prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (prev == s.charAt(i)) {
                return false;
            }
            prev = s.charAt(i);
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(hasAlternatingBits(11));

    }

}
