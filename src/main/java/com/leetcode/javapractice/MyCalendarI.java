package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

class MyCalendar {

    private List<int[]> books;

    public MyCalendar() {
        this.books = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] b : books) {
            if (Math.max(b[0], start) < Math.min(b[1], end)) {
                return false;
            }
        }
        books.add(new int[] {start, end});
        return true;
    }
}

public class MyCalendarI {

    public static void main(String[] args) {

        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }
}
