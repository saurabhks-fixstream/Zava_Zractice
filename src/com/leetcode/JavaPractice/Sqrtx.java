package com.leetcode.JavaPractice;

public class Sqrtx {

    public static int mySqrt(int x) {
        long start = 0;
        long end = x;
        while (start <= end) {
            long mid = (start + end) / 2;
            if ((mid * mid) <= x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int) end;
    }

    public static void main(String[] args) {

        System.out.println(mySqrt(2147395599));

    }

}
