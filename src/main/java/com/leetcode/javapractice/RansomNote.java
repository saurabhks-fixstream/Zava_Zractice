package com.leetcode.javapractice;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] letters = new char[26];
        for (char m : magazine.toCharArray()) {
            letters[m - 'a']++;
        }
        for (char r : ransomNote.toCharArray()) {
            if (letters[r - 'a'] < 1) {
                return false;
            }
            letters[r - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
    }
}
