package com.leetcode.javapractice;

import java.util.ArrayDeque;
import java.util.Deque;

class MovingAverage {

    Deque<Integer> queue;
    int size;
    double sum;

    public MovingAverage(int size) {
        this.queue = new ArrayDeque<Integer>();
        this.size = size;
        this.sum = 0.0;
    }

    public double next(int val) {
        sum += val;
        queue.offer(val);
        if (queue.size() <= size) {
            return sum / queue.size();
        } else {
            sum -= queue.poll();
            return sum / size;
        }
    }
}

public class MovingAveragefromDataStream {

    public static void main(String[] args) {

        MovingAverage obj = new MovingAverage(3);
        System.out.println(obj.next(1));
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));
    }
}
