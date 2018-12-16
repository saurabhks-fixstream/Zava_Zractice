package com.leetcode.JavaPractice;

public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        String c = "";
        int length1 = a.length();
        int length2 = b.length();
        int carry = 0;
        if (length1 <= length2) {
            int i = length2 - length1;
            while (i != 0) {
                c += "0";
                i--;
            }
            a = c + a;
            length1 = a.length();
        } else {
            int i = length1 - length2;
            while (i != 0) {
                c += "0";
                i--;
            }
            b = c + b;
            length2 = b.length();
        }
        while (length1 != 0 && length2 != 0) {
            int s1 = Character.getNumericValue(a.charAt(--length1));
            int s2 = Character.getNumericValue(b.charAt(--length2));
            int sum = s1 + s2 + carry;
            if (sum > 1) {
                carry = 1;
                if (sum == 2) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            } else {
                carry = 0;
                sb.append(sum);
            }
        }
        if (carry == 1) {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(addBinary("1010110", "1011110011"));

    }

}
