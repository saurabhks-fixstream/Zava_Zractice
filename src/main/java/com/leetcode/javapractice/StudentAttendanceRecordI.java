package com.leetcode.javapractice;

public class StudentAttendanceRecordI {

    public static boolean checkRecord(String s) {
        int a = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                a++;
                if (a > 1) {
                    return false;
                }
            }
        }
        return s.contains("LLL") ? false : true;
    }

    public static void main(String[] args) {

        System.out.println(checkRecord("PPALLP"));
        System.out.println(checkRecord("PPALLL"));
    }
}
