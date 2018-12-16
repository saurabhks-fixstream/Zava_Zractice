package com.leetcode.JavaPractice;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int carry = 0;
        int length = digits.length - 1;
        int i;
        for (i = length; i >= 0; i--) {
            int sum = 0;
            if (i == length) {
                sum += digits[i] + 1;
            } else {
                sum += digits[i] + carry;
            }
            if (sum >= 10) {
                carry = 1;
                digits[i] = sum - 10;
            } else {
                carry = 0;
                digits[i] = sum;
            }
        }
        if (carry == 1) {
            length += 2;
        } else {
            length += 1;
        }
        int j = 0;
        i = 0;
        int[] number = new int[length];
        if (carry == 1) {
            number[0] = 1;
            j++;
        }
        for (; j < length; j++) {
            number[j] = digits[i++];
        }
        return number;
    }

    public static void main(String[] args) {

        int[] digits = { 9, 9, 9 };
        int[] number = plusOne(digits);
        System.out.print("[");
        for (int i : number) {
            System.out.print(i + ", ");
        }
        System.out.println("]");

    }

}
