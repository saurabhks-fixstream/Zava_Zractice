package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerfulIntegers {

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> result = new ArrayList<Integer>();
        int k = (int) Math.log10(bound) + 5;
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= k; j++) {
                int power = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (power <= bound && !result.contains(power)) {
                    result.add(power);
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {

        System.out.println(powerfulIntegers(1, 2, 100));

    }

}
