package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public static List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int last = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, lastIndex[S.charAt(i) - 'a']);
            if (last == i) {
                result.add(last - start + 1);
                start = last + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
