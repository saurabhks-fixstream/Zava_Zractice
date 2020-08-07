package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void combinationSumHelper(
            int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> result) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<Integer>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                combinationSumHelper(candidates, target - candidates[i], i, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
    }
}
