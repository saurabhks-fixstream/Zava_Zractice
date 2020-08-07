package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddtoArrayFormofInteger {

    public static List<Integer> addToArrayForm(int[] A, int K) {
        int carry = 0;
        int i = A.length - 1;
        List<Integer> result = new ArrayList<Integer>();
        while (K > 0) {
            int digit = K % 10;
            int sum = digit + carry;
            if (i >= 0) {
                sum += A[i--];
            }
            carry = sum / 10;
            result.add(sum % 10);
            K /= 10;
        }
        while (i >= 0) {
            int sum = A[i--] + carry;
            carry = sum / 10;
            result.add(sum % 10);
        }
        if (carry != 0) {
            result.add(carry);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 0, 0};
        System.out.println(addToArrayForm(A, 34));

    }

}
