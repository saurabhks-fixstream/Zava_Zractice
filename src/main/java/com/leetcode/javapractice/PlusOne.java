package com.leetcode.javapractice;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = 0;
            sum += digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        int[] number = new int[carry == 1 ? digits.length + 1 : digits.length];
        int j = 0;
        if (carry == 1) {
            number[0] = 1;
            j++;
        }
        for (int i = 0; i < digits.length & j < number.length; i++, j++) {
            number[j] = digits[i];
        }
        return number;
    }

    public static void main(String[] args) {

        int[] digits = {9, 9, 9};
        int[] number = plusOne(digits);
        System.out.print("[");
        for (int i : number) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }
}
