package com.leetcode.javapractice;

public class RobotBoundedInCircle {

    public static boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0) {
            return true;
        }
        int dirs[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int i = 0;
        int x = 0;
        int y = 0;
        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'R') {
                i = (i + 1) % 4;
            } else if (instruction == 'L') {
                i = (i + 3) % 4;
            } else {
                x += dirs[i][0];
                y += dirs[i][1];
            }
        }
        return x == 0 && y == 0 || i > 0;
    }

    public static void main(String[] args) {

        System.out.println(isRobotBounded("GGLLGG"));

    }

}
