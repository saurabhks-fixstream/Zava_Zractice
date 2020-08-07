package com.leetcode.javapractice;

public class ThekthFactorofn {

    public static int kthFactor(int n, int k) {
        for (int d = 1; d <= n / 2; d++) {
            if (n % d == 0 && --k == 0) {
                return d;
            }
        }
        return k == 1 ? n : -1;
    }

    public static void main(String[] args) {

        System.out.println(kthFactor(12, 3));
    }
}
