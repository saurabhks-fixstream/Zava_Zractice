package com.leetcode.javapractice;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

    public static int longestSubstring(String s, int k) {
        return longestSubstringHelper(s, 0, s.length(), k);
    }

    public static int longestSubstringHelper(String s, int start, int end, int k) {
        if (end < k) {
            return 0;
        }
        int[] countMap = new int[26];
        for (int i = start; i < end; i++) {
            countMap[s.charAt(i) - 'a']++;
        }
        for (int mid = start; mid < end; mid++) {
            if (countMap[s.charAt(mid) - 'a'] >= k) {
                continue;
            }
            int midNext = mid + 1;
            while (midNext < end && countMap[s.charAt(midNext) - 'a'] < k) {
                midNext++;
            }
            return Math.max(
                    longestSubstringHelper(s, start, mid, k), longestSubstringHelper(s, midNext, end, k));
        }
        return (end - start);
    }

    public static void main(String[] args) {

        System.out.println(longestSubstring("aaabb", 3));
    }
}
