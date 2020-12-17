package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> resultList = new ArrayList<List<String>>();
        partitionHelper(s, 0, new ArrayList<String>(), resultList);
        return resultList;
    }

    public static void partitionHelper(
            String s, int l, List<String> currList, List<List<String>> resultList) {
        if (currList.size() > 0 && l >= s.length()) {
            resultList.add(new ArrayList<String>(currList));
        }
        for (int i = l; i < s.length(); i++) {
            if (isPalindrome(s, l, i)) {
                if (l == i) {
                    currList.add(Character.toString(s.charAt(i)));
                } else {
                    currList.add(s.substring(l, i + 1));
                }
                partitionHelper(s, i + 1, currList, resultList);
                currList.remove(currList.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str, int l, int r) {
        if (l == r) {
            return true;
        }
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(partition("aab"));
    }
}
