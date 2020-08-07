package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class NumberofSegmentsinaString {

    public static int countSegments(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int count = 0;
        s = s + " ";
        List<String> str = new ArrayList<String>();
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                t += s.charAt(i);
            } else {
                if (t != "") {
                    str.add(t);
                    t = "";
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(countSegments("     hi             "));
    }
}
