package com.leetcode.javapractice;

import java.util.ArrayDeque;
import java.util.Deque;

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

public class NumberofRecentCalls {

    public static void main(String[] args) {

        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }
}
