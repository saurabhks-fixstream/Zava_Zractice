package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq =
                new PriorityQueue<List<Integer>>((a, b) -> Integer.compare((a.get(0) + a.get(1)),
                        (b.get(0) + b.get(1))));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length & (i * j) <= k; j++) {
                pq.offer(Arrays.asList(nums1[i], nums2[j]));
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (k-- > 0 && !pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        System.out.println(kSmallestPairs(nums1, nums2, 3));

    }

}
