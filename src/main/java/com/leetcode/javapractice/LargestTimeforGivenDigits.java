package com.leetcode.javapractice;

public class LargestTimeforGivenDigits {

    public static String largestTimeFromDigits(int[] A) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    String hour = "" + A[i] + A[j];
                    String minute = "" + A[k] + A[6 - i - j - k];
                    String time = hour + ":" + minute;
                    if (hour.compareTo("24") < 0
                            && minute.compareTo("60") < 0
                            && result.compareTo(time) < 0) {
                        result = time;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4};
        System.out.println(largestTimeFromDigits(A));
    }
}
