package com.leetcode.javapractice;

public class WaterBottles {

    public static int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        int empty = numBottles;
        while (numBottles > 0) {
            numBottles = empty / numExchange;
            count += numBottles;
            empty += numBottles;
            empty -= numBottles * numExchange;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(numWaterBottles(9, 3));

    }

}
