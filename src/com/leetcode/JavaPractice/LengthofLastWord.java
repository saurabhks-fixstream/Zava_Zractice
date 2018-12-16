package com.leetcode.JavaPractice;

public class LengthofLastWord {

    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        int count = 0;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        while (end >= 0 && s.charAt(end) != ' ') {
            count++;
            end--;
        }
        return count;
    }

    public static void main(String[] args) {

        String s = "The foxed";
        System.out.println(lengthOfLastWord(s));

    }

}
