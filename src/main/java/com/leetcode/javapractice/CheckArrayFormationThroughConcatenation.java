package com.leetcode.javapractice;

public class CheckArrayFormationThroughConcatenation {

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        String arrString = arrayToString(arr);
        for (int[] piece : pieces) {
            String pieceString = arrayToString(piece);
            if (!arrString.contains(pieceString)) {
                return false;
            }
        }
        return true;
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a).append('$');
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        int[] arr = {85};
        int[][] pieces = {{85}};
        System.out.println(canFormArray(arr, pieces));
    }
}
