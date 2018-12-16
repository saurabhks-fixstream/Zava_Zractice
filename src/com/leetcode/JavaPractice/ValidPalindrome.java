package com.leetcode.JavaPractice;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        String original = sb.toString();
        sb.reverse();
        if (original.equals(sb.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

    }

}
