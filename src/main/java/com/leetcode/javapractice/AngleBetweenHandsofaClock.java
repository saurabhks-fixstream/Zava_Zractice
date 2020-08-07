package com.leetcode.javapractice;

public class AngleBetweenHandsofaClock {

    public static double angleClock(int hour, int minutes) {
        double h = (hour % 12 + minutes / 60.0) * 30;
        double m = minutes * 6;
        double angle = Math.abs(h - m);
        return Math.min(angle, 360 - angle);
    }

    public static void main(String[] args) {

        System.out.println(angleClock(12, 30));
    }
}
