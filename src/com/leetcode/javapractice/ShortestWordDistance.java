package com.leetcode.javapractice;

public class ShortestWordDistance {

    public static int shortestDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int idx1 = -1;
        int idx2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
            } else if (words[i].equals(word2)) {
                idx2 = i;
            }
            if (idx1 != -1 && idx2 != -1) {
                min = Math.min(min, Math.abs(idx1 - idx2));
            }
        }
        return min;
    }

    public static void main(String[] args) {

        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestDistance(words, "coding", "practice"));

    }

}
