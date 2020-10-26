package com.leetcode.javapractice;

import java.util.Stack;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[] {};
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && -asteroids[i] > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else if (stack.peek() == -asteroids[i]) {
                    stack.pop();
                }
            }
        }
        int[] result = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {

        int[] asteroids = {5, 10, -5};
        int[] result = asteroidCollision(asteroids);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
