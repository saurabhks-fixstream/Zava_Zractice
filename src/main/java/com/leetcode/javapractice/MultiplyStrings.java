package com.leetcode.javapractice;

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                arr[i + j + 1] += carry + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                carry = arr[i + j + 1] / 10;
                arr[i + j + 1] %= 10;
            }
            arr[i] = carry;
        }
        int i = 0;
        while (i < arr.length && arr[i] == 0) {
            i++;
        }
        if (i >= arr.length) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < arr.length; j++) {
            sb.append(arr[j]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(multiply("3938", "79389"));
    }
}
