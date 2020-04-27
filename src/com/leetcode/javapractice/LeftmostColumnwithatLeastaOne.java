package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class LeftmostColumnwithatLeastaOne {

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int n = list.get(0);
        int m = list.get(1);
        int x = 0;
        int y = m - 1;
        while (x < n && y >= 0) {
            if (binaryMatrix.get(x, y) == 0) {
                x++;
            } else {
                y--;
            }
        }
        return y + 1 == m ? -1
                          : y + 1;
    }

    public static void main(String[] args) {

        System.out.println(leftMostColumnWithOne(new BinaryMatrix()));

    }

}

class BinaryMatrix {

    int[][] matrix = { { 0, 0 }, { 1, 1 } };

    public int get(int x, int y) {
        return matrix[x][y];
    }

    public List<Integer> dimensions() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(matrix.length);
        list.add(matrix[0].length);
        return list;
    }

}
