package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class LongestDuplicateSubstring {

    public static String longestDupSubstring(String S) {
        int start = 0;
        int end = S.length() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isDuplicatePresent(S, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return findDuplicate(S, start - 1);
    }

    private static boolean isDuplicatePresent(String S, int length) {
        if (length == 0) {
            return true;
        }
        return findDuplicate(S, length) != null;
    }

    private static String findDuplicate(String S, int length) {
        long hash = 0;
        long prime = 29;
        long firstEntryPower = 1;
        for (int i = 0; i < length; i++) {
            firstEntryPower *= prime;
            hash = hash * prime + (S.charAt(i) - 'a');
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(hash, 0);
        for (int i = length; i < S.length(); i++) {
            hash = hash * prime + (S.charAt(i) - 'a');
            hash -= firstEntryPower * (S.charAt(i - length) - 'a');
            if (map.containsKey(hash)) {
                int index = map.get(hash);
                return S.substring(index, index + length);
            }
            map.put(hash, i - length + 1);
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println(longestDupSubstring("banana"));

    }

}
