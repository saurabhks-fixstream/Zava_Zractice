package com.leetcode.javapractice;

public class RomantoInteger {

    public static int romanToInt(String s) {
        int number = 0;
        int i = 0;
        while (i < s.length()) {
            char ch1 = s.charAt(i);
            char ch2 = ' ';
            if (i != s.length() - 1) {
                ch2 = s.charAt(i + 1);
            }
            if (ch1 == 'I' && ch2 == 'V') {
                number += 4;
                i++;
            } else if (ch1 == 'I' && ch2 == 'X') {
                number += 9;
                i++;
            } else if (ch1 == 'I') {
                number += 1;
            } else if (ch1 == 'V') {
                number += 5;
            } else if (ch1 == 'X' && ch2 == 'L') {
                number += 40;
                i++;
            } else if (ch1 == 'X' && ch2 == 'C') {
                number += 90;
                i++;
            } else if (ch1 == 'X') {
                number += 10;
            } else if (ch1 == 'C' && ch2 == 'D') {
                number += 400;
                i++;
            } else if (ch1 == 'C' && ch2 == 'M') {
                number += 900;
                i++;
            } else if (ch1 == 'C') {
                number += 100;
            } else if (ch1 == 'D') {
                number += 500;
            } else if (ch1 == 'M') {
                number += 1000;
            } else if (ch1 == 'L') {
                number += 50;
            }
            i++;
        }
        return number;
    }

    public static void main(String[] args) {

        System.out.println(romanToInt("DCCCLXXVI"));

    }

}
