package com.leetcode.javapractice;

public class ConsecutiveCharacters {

    public static int maxPower(String s) {
        char prev = ' ';
        int power = 1;
        int maxPower = 1;
        for (char c : s.toCharArray()) {
            if (c == prev) {
                power++;
            } else {
                maxPower = Math.max(maxPower, power);
                power = 1;
            }
            prev = c;
        }
        return Math.max(maxPower, power);
    }

    public static void main(String[] args) {

        System.out.println(maxPower("leetcode"));

    }

}
