package com.leetcode.JavaPractice;

public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int length = s.length();
        for (int i = length / 2; i > 0; i--) {
            if (length % i == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0, i));
                String str = sb.toString();
                int count = length / i;
                while (count > 1) {
                    sb.append(str);
                    count--;
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String s = "ababab";
        System.out.println(repeatedSubstringPattern(s));

    }

}
