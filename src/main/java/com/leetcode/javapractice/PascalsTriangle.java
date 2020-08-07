package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return list;
        } else {
            list.add(new ArrayList<Integer>());
            list.get(0).add(1);
            for (int i = 2; i <= numRows; i++) {
                List<Integer> ll = new ArrayList<Integer>();
                List<Integer> pll = list.get(i - 2);
                for (int j = 0; j < i; j++) {
                    if (j == 0) {
                        ll.add(pll.get(j));
                    } else if (j == i - 1) {
                        ll.add(pll.get(j - 1));
                    } else {
                        ll.add(pll.get(j) + pll.get(j - 1));
                    }
                }
                list.add(ll);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        List<List<Integer>> list = generate(6);
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            List<Integer> ll = list.get(i);
            System.out.print("[");
            for (Integer j : ll) {
                System.out.print(j + ",");
            }
            System.out.print("],");
        }
        System.out.println("]");
    }
}
