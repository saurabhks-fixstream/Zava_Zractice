package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            int size = result.size();
            for (int k = size - 1; k >= 0; k--) {
                result.add(result.get(k) | 1 << i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(grayCode(2));
    }
}
