package com.leetcode.javapractice;

public class MinimumCosttoMoveChipstoTheSamePosition {

    public static int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int pos : position) {
            if (pos % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args) {

        int[] position = {1, 2, 3};
        System.out.println(minCostToMoveChips(position));
    }
}
