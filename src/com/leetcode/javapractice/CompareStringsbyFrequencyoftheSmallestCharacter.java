package com.leetcode.javapractice;

import java.util.Arrays;

public class CompareStringsbyFrequencyoftheSmallestCharacter {

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] frequencyw = frequency(words);
        int[] frequencyq = frequency(queries);
        Arrays.sort(frequencyw);
        int[] ans = new int[frequencyq.length];
        for (int i = 0; i < frequencyq.length; i++) {
            int index = Arrays.binarySearch(frequencyw, frequencyq[i]);
            if (index >= 0) {
                while (index < frequencyw.length && frequencyw[index] == frequencyq[i]) {
                    ++index;
                }
            } else {
                index = ~index;
            }
            ans[i] = frequencyw.length - index;
        }
        return ans;
    }

    private static int[] frequency(String[] words) {
        int[] frequency = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int[] count = new int[26];
            int minIndex = 'z' - 'a';
            for (char c : words[i].toCharArray()) {
                ++count[c - 'a'];
                minIndex = Math.min(minIndex, c - 'a');
            }
            frequency[i] = count[minIndex];
        }
        return frequency;
    }

    public static void main(String[] args) {

        String[] queries = {"bbb", "cc"};
        String[] words = {"a", "aa", "aaa", "aaaa"};
        int[] ans = numSmallerByFrequency(queries, words);
        for (int i : ans) {
            System.out.print(i + ",");
        }

    }

}
