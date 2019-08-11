package com.leetcode.javapractice;

public class DayoftheYear {

    public static int dayOfYear(String date) {
        int[] daysOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8, 10));
        boolean leap = checkLeapYear(year);
        int days = 0;
        for (int i = 0; i < month - 1; i++) {
            if (leap && i == 1) {
                days += 1 + daysOfMonth[i];
            } else {
                days += daysOfMonth[i];
            }
        }
        return days + day;
    }

    private static boolean checkLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(dayOfYear("1976-01-24"));

    }

}
