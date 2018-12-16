package com.leetcode.JavaPractice;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<Integer>();
        if (rowIndex == 0) {
            prev.add(1);
            return prev;
        } else {
            prev.add(1);
            for (int i = 1; i <= rowIndex; i++) {
                List<Integer> curr = new ArrayList<Integer>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        curr.add(prev.get(j));
                    } else if (j == i) {
                        curr.add(prev.get(j - 1));
                    } else {
                        curr.add(prev.get(j) + prev.get(j - 1));
                    }
                }
                prev = curr;
            }
        }
        return prev;
    }

    public static void main(String[] args) {

        List<Integer> list = getRow(4);
        System.out.print("[");
        for (Integer j : list) {
            System.out.print(j + ",");
        }
        System.out.println("]");

    }

}
