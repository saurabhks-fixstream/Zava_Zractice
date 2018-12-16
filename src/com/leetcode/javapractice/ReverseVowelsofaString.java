package com.leetcode.javapractice;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsofaString {

    public static String reverseVowels(String s) {
        if (s.length() == 0) {
            return s;
        }
        Set<Character> vowels = new HashSet<Character>();
        char[] ch = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
        for (char c : ch) {
            vowels.add(c);
        }
        int start = 0;
        int end = s.length() - 1;
        char[] input = s.toCharArray();
        while (start <= end) {
            if (vowels.contains(input[start]) && vowels.contains(input[end])) {
                char c = input[start];
                input[start] = input[end];
                input[end] = c;
                start++;
                end--;
            } else if (!vowels.contains(input[start])) {
                start++;
            } else if (!vowels.contains(input[end])) {
                end--;
            } else {
                start++;
                end--;
            }
        }
        return new String(input);
    }

    public static void main(String[] args) {

        String s = "leetcode";
        System.out.println(reverseVowels(s));

    }

}
