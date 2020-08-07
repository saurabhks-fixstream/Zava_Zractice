package com.leetcode.javapractice;

public class BaseballGame {

    public static int calPoints(String[] ops) {
        int[] arr = new int[ops.length];
        int sum = 0;
        int k = 0;
        for (String s : ops) {
            char ch = s.charAt(0);
            if (ch != 'C' && ch != 'D' && ch != '+') {
                arr[k] = Integer.parseInt(s);
            }
            k++;
        }
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].charAt(0) == 'C') {
                int j = i;
                int l;
                for (l = j; l >= 0; l--) {
                    if (arr[l] != 0) {
                        break;
                    }
                }
                arr[l] = 0;
            }
            if (ops[i].charAt(0) == 'D') {
                int j = i;
                int prev = 0;
                for (int l = j; l >= 0; l--) {
                    if (arr[l] != 0) {
                        prev = arr[l];
                        break;
                    }
                }
                arr[i] = 2 * prev;
            }
            if (ops[i].charAt(0) == '+') {
                int j = i;
                int prev = 0;
                int count = 0;
                for (int l = j; l >= 0; l--) {
                    if (arr[l] != 0 && count < 2) {
                        prev += arr[l];
                        count++;
                    }
                }
                arr[i] = prev;
            }
        }
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops));

    }

}
