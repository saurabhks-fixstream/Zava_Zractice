package com.leetcode.javapractice;

import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {

    public static boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        long total = 0;
        for (int a : target) {
            total += a;
            pq.add(a);
        }
        while (true) {
            int a = pq.poll();
            total -= a;
            if (a == 1 || total == 1) {
                return true;
            }
            if (a < total || total == 0 || a % total == 0) {
                return false;
            }
            a %= total;
            total += a;
            pq.add(a);
        }
    }

    public static void main(String[] args) {

        int[] target = {9, 3, 5};
        System.out.println(isPossible(target));
    }
}
