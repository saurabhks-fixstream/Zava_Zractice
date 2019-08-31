package com.leetcode.javapractice;

public class FindWordsThatCanBeFormedbyCharacters {

    public static int countCharacters(String[] words, String chars) {
        int sum = 0;
        char[] alphabets = new char[26];
        for (char c : chars.toCharArray()) {
            alphabets[c - 'a']++;
        }
        for (String word : words) {
            int count = 0;
            char[] temp = alphabets.clone();
            for (char c : word.toCharArray()) {
                if (temp[c - 'a'] != 0) {
                    count++;
                    temp[c - 'a']--;
                } else {
                    break;
                }
            }
            if (count == word.length()) {
                sum += count;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        String[] words = { "cat", "bt", "hat", "tree" };
        String chars = "atach";
        System.out.println(countCharacters(words, chars));

    }

}
