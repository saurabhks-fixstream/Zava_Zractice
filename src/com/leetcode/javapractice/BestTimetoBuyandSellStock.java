package com.leetcode.javapractice;

public class BestTimetoBuyandSellStock {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int minprice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - minprice);
            }
        }
        return profit;
    }

    public static void main(String[] args) {

        int[] prices = {2, 1, 2, 1, 0, 1, 2};
        System.out.println(maxProfit(prices));

    }

}
