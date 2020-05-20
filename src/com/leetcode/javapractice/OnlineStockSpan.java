package com.leetcode.javapractice;

import java.util.Stack;

class StockSpanner {

    Stack<Integer> prices;
    Stack<Integer> weights;

    public StockSpanner() {
        prices = new Stack<Integer>();
        weights = new Stack<Integer>();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }
        prices.push(price);
        weights.push(w);
        return w;
    }

}

public class OnlineStockSpan {

    public static void main(String[] args) {

        StockSpanner S = new StockSpanner();
        System.out.println(S.next(100));
        System.out.println(S.next(80));
        System.out.println(S.next(60));
        System.out.println(S.next(70));
        System.out.println(S.next(60));
        System.out.println(S.next(75));
        System.out.println(S.next(85));

    }

}
