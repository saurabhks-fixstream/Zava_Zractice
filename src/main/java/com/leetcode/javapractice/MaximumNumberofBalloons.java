package com.leetcode.javapractice;

public class MaximumNumberofBalloons {

    public static int maxNumberOfBalloons(String text) {
        char[] chars = new char[26];
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
        }
        int min = chars[1];
        min = Math.min(min, chars[0]);
        min = Math.min(min, chars[11] / 2);
        min = Math.min(min, chars[14] / 2);
        min = Math.min(min, chars[13]);
        return min;
    }

    public static void main(String[] args) {

        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }
}
