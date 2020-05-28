package com.leetcode.javapractice;

public class CheckIfaWordOccursAsaPrefixofAnyWordinaSentence {

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(isPrefixOfWord("i love eating burger", "burg"));

    }

}
