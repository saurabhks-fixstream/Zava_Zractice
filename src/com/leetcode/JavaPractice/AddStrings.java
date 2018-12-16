package com.leetcode.JavaPractice;

public class AddStrings {

    public static String addStrings(String num1, String num2) {
        int carry = 0;
        String sum = "";
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        if (l1 < l2) {
            int diff = l2 - l1;
            while (diff > 0) {
                num1 = "0" + num1;
                diff--;
            }
        } else if (l2 < l1) {
            int diff = l1 - l2;
            while (diff > 0) {
                num2 = "0" + num2;
                diff--;
            }
        }
        l1 = num1.length() - 1;
        l2 = num2.length() - 1;
        while (l1 >= 0 && l2 >= 0) {
            int add = (num1.charAt(l1) - '0') + (num2.charAt(l2) - '0') + carry;
            if (add > 9) {
                carry = 1;
                add -= 10;
            } else {
                carry = 0;
            }
            sum = add + sum;
            l1--;
            l2--;
        }
        if (carry == 1) {
            sum = carry + sum;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(addStrings("31", "989"));

    }

}
