package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class XofaKindinaDeckofCards {

    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int X = 0;
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) >= X) {
                X = map.get(i);
            }
        }
        int hcf = X;
        for (int i : map.keySet()) {
            int value = map.get(i);
            hcf = hcf(value, hcf);
        }
        return hcf >= 2;
    }

    private static int hcf(int a, int b) {
        if (b == 0)
            return a;
        return hcf(b, a % b);
    }

    public static void main(String[] args) {

        int[] deck = { 1, 2, 3, 4, 4, 3, 2, 1 };
        System.out.println(hasGroupsSizeX(deck));

    }

}
