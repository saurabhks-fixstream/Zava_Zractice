package com.leetcode.JavaPractice;

public class NumberComplement {

    public static int power(int a, int b) {
        int pow = 1;
        for (int i = 1; i <= b; i++) {
            pow *= a;
        }
        return pow;
    }

    public static int findComplement(int num) {
        int n = 0, num1 = 0;
        while (num != 0) {
            int i;
            i = num % 2;
            if (i == 0) {
                num1 += (power(2, n++) * 1);
            } else {
                num1 += (power(2, n++) * 0);
            }
            num /= 2;
        }
        return num1;
    }

    public static void main(String[] args) {

        System.out.println(findComplement(10));

    }

}
