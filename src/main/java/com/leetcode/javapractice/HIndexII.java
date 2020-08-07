package com.leetcode.javapractice;

public class HIndexII {

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] == n - mid) {
                return n - mid;
            }
            if (citations[mid] < n - mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return n - start;
    }

    public static void main(String[] args) {

        int[] citations = {0, 1, 3, 5, 6};
        System.out.println(hIndex(citations));
    }
}
