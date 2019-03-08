package com.leetcode.javapractice;

public class SumofEvenNumbersAfterQueries {

    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[queries.length];
        int sum = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                sum += a;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 == 0) {
                sum -= A[index];
            }
            A[index] += val;
            if (A[index] % 2 == 0) {
                sum += A[index];
            }
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] A = { 1, 2, 3, 4 };
        int[][] queries = { { 1, 0 }, { -3, 1 }, { -4, 0 }, { 2, 3 } };
        int[] result = sumEvenAfterQueries(A, queries);
        for (int r : result) {
            System.out.print(r + " ");
        }

    }

}
