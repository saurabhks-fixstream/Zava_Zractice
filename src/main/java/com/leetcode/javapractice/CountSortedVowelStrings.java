package com.leetcode.javapractice;

public class CountSortedVowelStrings {
    public static int countVowelStrings(int n) {
        return countVowelStringsHelper(n, 1);
    }

    public static int countVowelStringsHelper(int n, int vowel) {
        if (n == 0) {
            return 1;
        }
        int result = 0;
        for (int i = vowel; i <= 5; i++) {
            result += countVowelStringsHelper(n - 1, i);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(countVowelStrings(2));
    }
}
