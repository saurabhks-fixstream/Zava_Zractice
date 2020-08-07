package com.leetcode.javapractice;

public class PrimeNumberofSetBitsinBinaryRepresentation {

    public static int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (isPrimary(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrimary(int number) {
        return number == 2
                || number == 3
                || number == 5
                || number == 7
                || number == 11
                || number == 13
                || number == 17
                || number == 19;
    }

    public static void main(String[] args) {

        System.out.println(countPrimeSetBits(842, 888));
    }
}
