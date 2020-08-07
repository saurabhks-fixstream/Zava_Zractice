package com.leetcode.javapractice;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {

    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        int diff = 0;
        int firstIndex = 0;
        int lastIndex = 0;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < A.length(); i++) {
            set.add(A.charAt(i));
            if (A.charAt(i) != B.charAt(i)) {
                diff++;
                if (diff == 1) {
                    firstIndex = i;
                }
                if (diff == 2) {
                    lastIndex = i;
                }
            }
        }
        if (diff == 0) {
            return set.size() < A.length() && A.equals(B);
        } else if (diff > 2) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            if (i == firstIndex) {
                sb.append(A.charAt(lastIndex));
            } else if (i == lastIndex) {
                sb.append(A.charAt(firstIndex));
            } else {
                sb.append(A.charAt(i));
            }
        }
        return sb.toString().equals(B);
    }

    public static void main(String[] args) {

        System.out.println(buddyStrings("accccb", "bcccca"));
    }
}
