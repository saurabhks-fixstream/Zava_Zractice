package com.leetcode.javapractice;

public class BestTimetoBuyandSellStockwithCooldown {

    public static int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int reset = 0;
        for (int price : prices) {
            int prevSold = sold;
            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, prevSold);
        }
        return Math.max(sold, reset);
    }

    public static void main(String[] args) {

        int[] prices = { 1, 2, 3, 0, 2 };
        System.out.println(maxProfit(prices));

    }

}
