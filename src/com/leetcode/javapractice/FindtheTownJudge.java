package com.leetcode.javapractice;

public class FindtheTownJudge {

    public static int findJudge(int N, int[][] trust) {
        if (N == 1) {
            return 1;
        }
        int[] trustedBy = new int[N];
        int[] trusts = new int[N];
        int max = -1;
        int index = -1;
        for (int i = 0; i < trust.length; i++) {
            int j = trust[i][0] - 1;
            int k = trust[i][1] - 1;
            trusts[j]++;
            trustedBy[k]++;
            if (trustedBy[k] >= max) {
                max = trustedBy[k];
                index = k;
            }
        }
        if (max != N - 1) {
            return -1;
        }
        return trusts[index] == 0 ? index + 1
                                  : -1;
    }

    public static void main(String[] args) {

        int N = 4;
        int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
        System.out.println(findJudge(N, trust));

    }

}
