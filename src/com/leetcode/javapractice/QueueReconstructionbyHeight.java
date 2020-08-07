package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionbyHeight {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1]
                : b[0] - a[0]);
        List<int[]> result = new ArrayList<int[]>();
        for (int[] p : people) {
            result.add(p[1], p);
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] result = reconstructQueue(people);
        System.out.print("[");
        for (int[] r : result) {
            System.out.print("[" + r[0] + "," + r[1] + "],");
        }
        System.out.println("]");

    }

}
