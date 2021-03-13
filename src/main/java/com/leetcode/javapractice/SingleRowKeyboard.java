package com.leetcode.javapractice;

public class SingleRowKeyboard {

    public static int calculateTime(String keyboard, String word) {
        int result = 0;
        int[] indexes = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            indexes[keyboard.charAt(i) - 'a'] = i;
        }
        int last = 0;
        for (int i = 0; i < word.length(); i++) {
            int index = indexes[word.charAt(i) - 'a'];
            result += Math.abs(index - last);
            last = index;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"));
    }
}
