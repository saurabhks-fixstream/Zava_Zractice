package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineifStringHalvesAreAlike {

    public static boolean halvesAreAlike(String s) {
        Set<Character> vowels =
                new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int a = 0;
        int b = 0;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            a += vowels.contains(s.charAt(i)) ? 1 : 0;
            b += vowels.contains(s.charAt(j)) ? 1 : 0;
        }
        return a == b;
    }

    public static void main(String[] args) {

        System.out.println(halvesAreAlike("book"));
    }
}
