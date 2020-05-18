package com.leetcode.javapractice;

public class PermutationinString {

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        int start = 0;
        int end = 0;
        int counter = s1.length();
        while (end < s2.length()) {
            int c1 = s2.charAt(end) - 'a';
            if (count[c1] > 0) {
                counter--;
            }
            count[c1]--;
            end++;
            while (counter == 0) {
                if (end - start == s1.length()) {
                    return true;
                }
                int c2 = s2.charAt(start) - 'a';
                count[c2]++;
                if (count[c2] > 0) {
                    counter++;
                }
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(checkInclusion("adc", "dcda"));

    }

}
