package com.leetcode.javapractice;

public class ConvertaNumbertoHexadecimal {

    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String result = "";
        while (num != 0) {
            result = hex[(num & 15)] + result;
            num >>>= 4;
        }
        return result;
    }

    public static void main(String[] args) {

        int num = -269;
        System.out.println(toHex(num));
    }
}
