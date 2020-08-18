package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {

    public static int[] numsSameConsecDiff(int N, int K) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 2; i <= N; i++) {
            List<Integer> newList = new ArrayList<Integer>();
            for (int n : list) {
                int digit = n % 10;
                if (n > 0 && digit + K < 10) {
                    newList.add(n * 10 + digit + K);
                }
                if (n > 0 && K > 0 && digit - K >= 0) {
                    newList.add(n * 10 + digit - K);
                }
            }
            list = newList;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] result = numsSameConsecDiff(3, 7);
        for (int i : result) {
            System.out.print(i + ", ");
        }
    }
}
