package com.leetcode.javapractice;

public class CountPrimes {

    private static boolean isPrime(int n) {
        if (n <= 3) {
            return true;
        }
        if (n % 3 == 0) {
            return false;
        }
        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 1;
        for (int i = 3; i < n; i += 2) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int n = 2;
        System.out.println(countPrimes(n));

    }

}
