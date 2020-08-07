package com.crackingthecodinginterview.javapractice;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    public static boolean isUniqueChars(String s) {
        s = s.toLowerCase();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isUniqueChars("GeeksforGeeks"));
    }
}
