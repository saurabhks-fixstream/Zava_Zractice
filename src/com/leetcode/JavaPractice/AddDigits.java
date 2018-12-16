package com.leetcode.JavaPractice;

public class AddDigits {

    public static int addDigits(int num) {
        int sum = 0;
        while (num != 0 || sum - 10 >= 0) {
            if (num == 0) {
                num = sum;
                sum = 0;
            }
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(addDigits(19));

    }

}
