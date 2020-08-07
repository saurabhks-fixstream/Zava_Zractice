package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class PositionsofLargeGroups {

    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (S == null || S.length() == 0) {
            return result;
        }
        int count = 1;
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) == S.charAt(i + 1)) {
                count++;
            } else {
                if (count >= 3) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i - count + 1);
                    list.add(i);
                    result.add(list);
                }
                count = 1;
            }
        }
        if (count >= 3) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(S.length() - count);
            list.add(S.length() - 1);
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(largeGroupPositions("abbxxxxzzy"));
    }
}
