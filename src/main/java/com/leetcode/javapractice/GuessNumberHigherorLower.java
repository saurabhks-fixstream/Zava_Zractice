package com.leetcode.javapractice;

class GuessGame {

    static double rand = Math.random();
    static double number = rand * 3;

    public static int guess(int num) {
        int nums = (int) number;
        if (nums < num) {
            return -1;
        } else if (nums > num) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class GuessNumberHigherorLower extends GuessGame {

    public static int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(guessNumber(3));
    }
}
