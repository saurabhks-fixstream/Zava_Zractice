package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class FindPositiveIntegerSolutionforaGivenEquation {

    public static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                List<Integer> list = new ArrayList<Integer>();
                if (customfunction.f(i, j) == z) {
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        CustomFunction customfunction = new CustomFunction();
        System.out.println(findSolution(customfunction, 5));
    }

    static class CustomFunction {

        public int f(int x, int y) {
            return x + y;
        }
    }
}
