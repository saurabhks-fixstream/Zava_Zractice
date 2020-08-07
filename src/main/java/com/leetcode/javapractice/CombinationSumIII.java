package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combinationSum3Helper(n, 1, k, new ArrayList<Integer>(), result);
        return result;
    }

    private static void combinationSum3Helper(
            int target, int start, int k, List<Integer> list, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (list.size() > k) {
            return;
        }
        if (list.size() == k && target == 0) {
            result.add(new ArrayList<Integer>(list));
        } else {
            for (int i = start; i <= 9; i++) {
                list.add(i);
                combinationSum3Helper(target - i, i + 1, k, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(combinationSum3(3, 7));
    }
}
