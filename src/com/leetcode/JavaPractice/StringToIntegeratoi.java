package com.leetcode.JavaPractice;

import java.util.ArrayList;
import java.util.List;

public class StringToIntegeratoi {

    public static int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        List<Character> list = new ArrayList<Character>();
        int spaces = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaces++;
            } else {
                break;
            }
        }
        for (int i = spaces; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        int neg = 1;
        if (list.get(0) == '-') {
            neg = -1;
            list.remove(0);
        } else if (list.get(0) == '+') {
            list.remove(0);
        }
        if (list.size() == 0) {
            return 0;
        }
        int count = 0;
        if (Character.isDigit(list.get(0))) {
            for (int i = 0; i < list.size(); i++) {
                if (Character.isDigit(list.get(i))) {
                    count++;
                } else {
                    break;
                }
            }
        } else {
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < count; i++) {
            sum += ((list.get(i) - '0') * Math.pow(10, count - i - 1));
        }
        sum = neg * sum;
        if (sum < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (sum > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) (sum);
    }

    public static void main(String[] args) {

        System.out.println(myAtoi("123"));

    }

}
