package com.leetcode.javapractice;

import java.util.Arrays;

public class LastStoneWeightII {

    public static int lastStoneWeightII(int[] stones) {
        int[][] memo = new int[stones.length][6001];
        for (int[] arr : memo) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return lastStoneWeightIIHelper(stones, 0, 0, memo);
    }

    private static int lastStoneWeightIIHelper(int[] stones, int index, int sum, int[][] memo) {
        if (index == stones.length) {
            return Math.abs(sum);
        } else {
            if (memo[index][sum + 3000] != Integer.MIN_VALUE) {
                return memo[index][sum + 3000];
            }
            memo[index][sum + 3000] = Math.min(lastStoneWeightIIHelper(stones, index + 1, sum + stones[index], memo),
                    lastStoneWeightIIHelper(stones, index + 1, sum - stones[index], memo));
            return memo[index][sum + 3000];
        }
    }

    public static void main(String[] args) {

        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII(stones));

    }

}
