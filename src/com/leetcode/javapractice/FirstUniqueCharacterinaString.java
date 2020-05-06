package com.leetcode.javapractice;

public class FirstUniqueCharacterinaString {

    public static int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int i = 0;
        for (char c : s.toCharArray()) {
            if (count[c - 'a'] == 1) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(firstUniqChar("geeksforgeeks"));

    }

}
