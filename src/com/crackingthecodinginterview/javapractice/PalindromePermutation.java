package com.crackingthecodinginterview.javapractice;

import java.util.HashMap;

public class PalindromePermutation {

    public static boolean isPermutationOfPalindrome(String phrase) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < phrase.length(); i++) {
            if (!map.containsKey(phrase.charAt(i))) {
                map.put(phrase.charAt(i), 1);
            } else {
                map.put(phrase.charAt(i), (map.get(phrase.charAt(i)) + 1));
            }
        }
        int countodd = 0;
        for (int i : map.values()) {
            if (i % 2 != 0) {
                countodd++;
            }
        }
        if (countodd > 1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {

        System.out.println(isPermutationOfPalindrome("tactcoa"));

    }

}
