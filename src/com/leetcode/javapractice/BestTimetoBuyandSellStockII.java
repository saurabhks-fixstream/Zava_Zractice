package com.leetcode.javapractice;

public class BestTimetoBuyandSellStockII {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int sum = 0;
            int j;
            for (j = i; j < prices.length - 1; j++) {
                if (prices[i] < prices[j + 1] && prices[j] <= prices[j + 1]) {
                    sum = Math.max(sum, prices[j + 1] - prices[i]);
                } else {
                    break;
                }
            }
            i = j;
            profit += sum;
        }
        return profit;
    }

    public static void main(String[] args) {

        int[] prices = { 1, 2, 4 };
        System.out.println(maxProfit(prices));

    }

}
