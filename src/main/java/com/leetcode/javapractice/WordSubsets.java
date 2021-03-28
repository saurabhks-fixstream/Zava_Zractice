package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public static List<String> wordSubsets(String[] A, String[] B) {
        int[] count = new int[26];
        int[] temp;
        int i;
        for (String b : B) {
            temp = counter(b);
            for (i = 0; i < 26; ++i) {
                count[i] = Math.max(count[i], temp[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String a : A) {
            temp = counter(a);
            for (i = 0; i < 26; ++i)
                if (temp[i] < count[i]) {
                    break;
                }
            if (i == 26) {
                result.add(a);
            }
        }
        return result;
    }

    private static int[] counter(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }

    public static void main(String[] args) {

        String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = {"e", "o"};
        System.out.println(wordSubsets(A, B));
    }
}
