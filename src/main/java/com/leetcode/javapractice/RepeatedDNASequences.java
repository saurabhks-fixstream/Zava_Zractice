package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        Set<String> set = new HashSet<String>();
        Set<String> resultSet = new HashSet<String>();
        for (int i = 0; i < s.length() - 10; i++) {
            String seq = s.substring(i, i + 10);
            if (set.contains(seq)) {
                resultSet.add(seq);
            } else {
                set.add(seq);
            }
        }
        result.addAll(resultSet);
        return result;
    }

    public static void main(String[] args) {

        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
