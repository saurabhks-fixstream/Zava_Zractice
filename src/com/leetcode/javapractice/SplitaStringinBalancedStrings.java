package com.leetcode.javapractice;

public class SplitaStringinBalancedStrings {

    public static int balancedStringSplit(String s) {
        int L = 0;
        int R = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                L++;
            }
            if (c == 'R') {
                R++;
            }
            if (L == R) {
                count++;
                L = 0;
                R = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(balancedStringSplit("RLRRLLRLRL"));

    }

}
