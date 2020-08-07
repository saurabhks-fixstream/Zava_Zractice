package com.leetcode.javapractice;

import java.util.Stack;

public class FinalPricesWithaSpecialDiscountinaShop {

    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }

    public static void main(String[] args) {

        int[] prices = {8, 4, 6, 2, 3};
        finalPrices(prices);
        for (int i : prices) {
            System.out.print(i + ", ");
        }
    }
}
