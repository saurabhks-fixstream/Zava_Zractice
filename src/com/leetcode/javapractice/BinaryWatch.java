package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<String>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if ((Integer.bitCount(h) + Integer.bitCount(m)) == num) {
                    list.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

        int num = 2;
        List<String> list = readBinaryWatch(num);
        System.out.println(list);

    }

}
