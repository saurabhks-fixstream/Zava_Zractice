package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    public static List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<String>();
        int[][] map = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            int[] alphabets = new int[26];
            for (char c : A[i].toCharArray()) {
                alphabets[c - 'a']++;
            }
            map[i] = alphabets;
        }
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; j++) {
                if (map[j][i] <= min) {
                    min = map[j][i];
                }
            }
            if (min > 0) {
                while (min-- > 0) {
                    ans.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        String[] A = {"bella", "label", "roller"};
        System.out.println(commonChars(A));
    }
}
