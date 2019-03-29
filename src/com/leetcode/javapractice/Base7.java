package com.leetcode.javapractice;

public class Base7 {

    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = (num < 0);
        if (negative) {
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (negative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(convertToBase7(100));

    }

}
