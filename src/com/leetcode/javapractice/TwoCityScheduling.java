package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {

    public static int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        Arrays.sort(costs, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                sum += costs[i][0];
            } else {
                sum += costs[i][1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        System.out.println(twoCitySchedCost(costs));

    }

}
