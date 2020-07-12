package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class ReformatDate {

    static Map<String, String> months = getMonths();

    public static String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        String[] tokens = date.split(" ");
        sb.append(tokens[2]).append("-");
        sb.append(months.get(tokens[1])).append("-");
        sb.append(tokens[0].length() == 3 ? ("0" + tokens[0].substring(0, 1))
                                          : tokens[0].substring(0, 2));
        return sb.toString();
    }

    private static Map<String, String> getMonths() {
        String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < months.length; i++) {
            map.put(months[i], String.format("%02d", i + 1));
        }
        return map;
    }

    public static void main(String[] args) {

        System.out.println(reformatDate("20th Oct 2052"));

    }

}
