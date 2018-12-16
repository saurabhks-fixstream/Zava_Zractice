package com.leetcode.JavaPractice;

public class ExcelSheetColumnTitle {

    public static String convertToTitle(int n) {
        String title = "";
        char[] alphabets = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                             'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        if (n <= 26) {
            title = Character.toString(alphabets[n - 1]);
            return title;
        }
        while (n > 0) {
            int temp = n;
            while (temp > 26) {
                temp -= 26;
            }
            title = Character.toString(alphabets[temp - 1]) + title;
            n = (n - 1) / 26;
        }
        return title;
    }

    public static void main(String[] args) {

        System.out.println(convertToTitle(520086));

    }

}
