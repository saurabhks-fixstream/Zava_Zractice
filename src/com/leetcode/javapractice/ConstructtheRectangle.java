package com.leetcode.javapractice;

public class ConstructtheRectangle {

    public static int[] constructRectangle(int area) {
        int[] result = new int[2];
        if (area == 0) {
            return result;
        }
        int start = area;
        int end = 1;
        int minDiff = area - 1;
        while (end <= start) {
            int product = start * end;
            int diff = start - end;
            if (product == area) {
                if (diff <= minDiff) {
                    minDiff = diff;
                    result[0] = start;
                    result[1] = end;
                }
                start--;
                end++;
            } else if (product > area) {
                start--;
            } else {
                end++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] cordinates = constructRectangle(50);
        System.out.println(cordinates[0] + "," + cordinates[1]);

    }

}
