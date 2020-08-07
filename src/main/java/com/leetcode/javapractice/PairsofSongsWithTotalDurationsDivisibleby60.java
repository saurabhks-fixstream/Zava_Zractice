package com.leetcode.javapractice;

public class PairsofSongsWithTotalDurationsDivisibleby60 {

    public static int numPairsDivisibleBy60(int[] time) {
        int c[] = new int[60];
        int res = 0;
        for (int t : time) {
            res += c[(60 - t % 60) % 60];
            c[t % 60] += 1;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] time = {30, 20, 150, 100, 40};
        System.out.println(numPairsDivisibleBy60(time));
    }
}
