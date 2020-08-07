package com.leetcode.javapractice;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int stone : stones) {
            queue.offer(stone);
        }
        for (int i = 0; i < stones.length - 1; i++) {
            queue.offer(queue.poll() - queue.poll());
        }
        return queue.poll();
    }

    public static void main(String[] args) {

        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }
}
