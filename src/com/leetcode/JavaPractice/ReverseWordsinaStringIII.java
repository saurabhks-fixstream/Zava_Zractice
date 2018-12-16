package com.leetcode.JavaPractice;

public class ReverseWordsinaStringIII {

    public static String reverseWords(String s) {
        s = s + " ";
        StringBuilder sb = new StringBuilder();
        int count = -1;
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (s.charAt(i) == ' ') {
                int j = i - 1;
                while (j >= (i - count)) {
                    if (s.charAt(j) != ' ') {
                        sb.append(s.charAt(j));
                    }
                    j--;
                }
                sb.append(" ");
                count = 0;
            }
        }
        return sb.substring(0, s.length() - 1);
    }

    public static void main(String[] args) {

        System.out.println(reverseWords("Let's take LeetCode contest"));

    }

}
