package com.leetcode.javapractice;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberofRecentCalls {

    class RecentCounter {

        Deque<Integer> deque;

        public RecentCounter() {
            this.deque = new ArrayDeque<Integer>();
        }

        public int ping(int t) {
            deque.offer(t);
            while (deque.peek() < t - 3000) {
                deque.poll();
            }
            return deque.size();
        }
    }

}
