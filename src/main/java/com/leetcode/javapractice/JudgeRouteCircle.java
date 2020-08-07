package com.leetcode.javapractice;

public class JudgeRouteCircle {

    public static boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                y++;
            } else if (moves.charAt(i) == 'D') {
                y--;
            } else if (moves.charAt(i) == 'R') {
                x++;
            } else if (moves.charAt(i) == 'L') {
                x--;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(judgeCircle("UUDDRRLLDD"));
    }
}
