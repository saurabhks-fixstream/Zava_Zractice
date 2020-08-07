package com.leetcode.javapractice;

public class NumberofStudentsDoingHomeworkataGivenTime {

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] startTime = {1, 2, 3};
        int[] endTime = {3, 2, 7};
        System.out.println(busyStudent(startTime, endTime, 4));

    }

}
