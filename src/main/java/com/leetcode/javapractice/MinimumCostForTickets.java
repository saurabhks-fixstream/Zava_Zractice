package com.leetcode.javapractice;

public class MinimumCostForTickets {

    public static int mincostTickets(int[] days, int[] costs) {
        int[] minCost = new int[366];
        boolean[] travelDay = new boolean[366];
        for (int day : days) {
            travelDay[day] = true;
        }
        for (int i = 1; i < 366; i++) {
            if (travelDay[i]) {
                minCost[i] =
                        Math.min(
                                minCost[i - 1] + costs[0],
                                Math.min(
                                        minCost[Math.max(0, i - 7)] + costs[1],
                                        minCost[Math.max(0, i - 30)] + costs[2]));
            } else {
                minCost[i] = minCost[i - 1];
            }
        }
        return minCost[365];
    }

    public static void main(String[] args) {

        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(mincostTickets(days, costs));
    }
}
