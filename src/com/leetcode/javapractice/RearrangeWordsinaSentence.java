package com.leetcode.javapractice;

import java.util.Arrays;

public class RearrangeWordsinaSentence {

    public static String arrangeWords(String text) {
        String[] words = text.toLowerCase().split(" ");
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        String ans = String.join(" ", words);
        return Character.toUpperCase(ans.charAt(0)) + ans.substring(1);
    }

    public static void main(String[] args) {

        System.out.println(arrangeWords("Leetcode is cool"));
        System.out.println(arrangeWords("Swxxmsh qjhcpm tlvmdbava usujd tyt zdn"));

    }

}
