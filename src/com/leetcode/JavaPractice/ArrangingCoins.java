package com.leetcode.JavaPractice;

public class ArrangingCoins {

    public static int arrangeCoins(int n) {
        double coins = Math.sqrt(.125 + n);
        coins *= Math.sqrt(2);
        coins -= .5;
        return (int) coins;
    }

    public static void main(String[] args) {

        System.out.println(arrangeCoins(2146467960));

    }

}
