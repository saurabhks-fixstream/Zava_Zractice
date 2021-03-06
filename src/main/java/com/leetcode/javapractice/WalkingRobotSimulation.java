package com.leetcode.javapractice;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {

    public static int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<String>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + " " + obstacle[1]);
        }
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int x = 0;
        int y = 0;
        int result = 0;
        for (int c : commands) {
            if (c == -1) {
                d++;
                if (d == 4) {
                    d = 0;
                }
            } else if (c == -2) {
                d--;
                if (d == -1) {
                    d = 3;
                }
            } else {
                while (c-- > 0 && !set.contains((x + dirs[d][0]) + " " + (y + dirs[d][1]))) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] commands = {4, -1, 3};
        int[][] obstacles = {};
        System.out.println(robotSim(commands, obstacles));
    }
}
