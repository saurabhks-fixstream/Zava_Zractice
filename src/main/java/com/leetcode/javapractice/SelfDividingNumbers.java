package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            int temp = i;
            int temp1 = i;
            int digits = 0, divisible = 0;
            while (temp != 0) {
                int j;
                j = temp % 10;
                digits++;
                if (j != 0 && temp1 % j == 0) {
                    divisible++;
                }
                temp /= 10;
            }
            if (digits == divisible) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        System.out.println(selfDividingNumbers(1, 100));
    }
}
