package com.leetcode.javapractice;

public class MaximumNumberofVowelsinaSubstringofGivenLength {

    public static int maxVowels(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int count = 0;
        int maxCount = 0;
        while (end < s.length()) {
            if (isVowel(s.charAt(end))) {
                count++;
            }
            end++;
            if (end - start == k) {
                maxCount = Math.max(maxCount, count);
                if (isVowel(s.charAt(start))) {
                    count--;
                }
                start++;
            }
        }
        return maxCount;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {

        System.out.println(maxVowels("abciiidef", 3));

    }

}
