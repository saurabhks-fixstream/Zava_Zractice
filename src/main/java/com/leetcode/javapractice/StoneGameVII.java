package com.leetcode.javapractice;

public class StoneGameVII {

    private static Integer[][] memo;
    private static int[] preSum;

    public static int stoneGameVII(int[] stones) {
        int n = stones.length;
        memo = new Integer[n][n];
        preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }
        return stoneGameVIIHelper(0, n - 1);
    }

    private static int getSum(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

    private static int stoneGameVIIHelper(int left, int right) {
        if (left > right) {
            return 0;
        }
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        int scoreRemoveLeftMost = getSum(left + 1, right);
        int scoreRemoveRightMost = getSum(left, right - 1);
        int ans =
                Math.max(
                        scoreRemoveLeftMost - stoneGameVIIHelper(left + 1, right),
                        scoreRemoveRightMost - stoneGameVIIHelper(left, right - 1));
        memo[left][right] = ans;
        return ans;
    }

    public static void main(String[] args) {

        int[] stones = {5, 3, 1, 4, 2};
        System.out.println(stoneGameVII(stones));
    }
}
