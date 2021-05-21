package com.leetcode.javapractice;

import java.util.Arrays;

public class PutBoxesIntotheWarehouseI {

    public static int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int m = boxes.length;
        int n = warehouse.length;
        int res = 0;
        for (int i = 0; i < m && res < n; i++) {
            if (boxes[m - i - 1] <= warehouse[res]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] boxes = {4, 3, 4, 1};
        int[] warehouse = {5, 3, 3, 4, 1};
        System.out.println(maxBoxesInWarehouse(boxes, warehouse));
    }
}
