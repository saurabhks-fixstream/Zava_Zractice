package com.leetcode.javapractice;

public class CountandSay {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String str = "11";
        for (int i = 3; i <= n; i++) {
            str += "$";
            int len = str.length();
            int count = 1;
            String temp = "";
            for (int j = 1; j < len; j++) {
                if (str.charAt(j) != str.charAt(j - 1)) {
                    temp += count;
                    temp += str.charAt(j - 1);
                    count = 1;
                } else {
                    count++;
                }
            }
            str = temp;
        }
        return str;
    }

    public static void main(String[] args) {

        System.out.println(countAndSay(5));

    }

}
