package com.leetcode.javapractice;

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed.length == 1) {
            return flowerbed[0] == 0 && n == 1;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i > 0 && flowerbed[i - 1] == 0 && i < flowerbed.length - 1 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                } else if (i == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                } else if (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {

        int[] flowerbed = {1, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(flowerbed, 1));

    }

}
