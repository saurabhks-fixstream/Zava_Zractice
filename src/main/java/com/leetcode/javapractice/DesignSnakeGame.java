package com.leetcode.javapractice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class SnakeGame {

    Deque<Integer> body;
    Set<Integer> set;
    int score;
    int foodptr;
    int height;
    int width;
    int[][] food;

    public SnakeGame(int width, int height, int[][] food) {
        this.height = height;
        this.width = width;
        this.food = food;
        this.score = 0;
        this.body = new ArrayDeque<Integer>();
        this.body.offerLast(0);
        this.set = new HashSet<Integer>();
        this.set.add(0);
    }

    public int move(String direction) {
        if (score == -1) {
            return -1;
        }
        int x = body.peekFirst() / width;
        int y = body.peekFirst() % width;
        switch (direction) {
            case "U":
                x--;
                break;
            case "D":
                x++;
                break;
            case "R":
                y++;
                break;
            case "L":
                y--;
                break;
        }
        int head = x * width + y;
        set.remove(body.peekLast());
        if (x < 0 || x >= height || y < 0 || y >= width || set.contains(head)) {
            return score = -1;
        }
        set.add(head);
        body.offerFirst(head);
        if (foodptr < food.length && x == food[foodptr][0] && y == food[foodptr][1]) {
            set.add(body.peekLast());
            foodptr++;
            return ++score;
        }
        body.pollLast();
        return score;
    }
}

public class DesignSnakeGame {

    public static void main(String[] args) {

        int[][] food = {{1, 2}, {0, 1}};
        SnakeGame snake = new SnakeGame(3, 2, food);
        System.out.println(snake.move("R"));
        System.out.println(snake.move("D"));
        System.out.println(snake.move("R"));
        System.out.println(snake.move("U"));
        System.out.println(snake.move("L"));
        System.out.println(snake.move("U"));
    }
}
