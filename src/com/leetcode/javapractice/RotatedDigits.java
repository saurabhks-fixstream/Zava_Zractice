package com.leetcode.javapractice;

public class RotatedDigits {

    public static int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (validPostRotation(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean validPostRotation(int N) {
        StringBuilder sb = new StringBuilder();
        int num = N;
        while (N > 0) {
            int digit = N % 10;
            switch (digit) {
                case 0:
                case 1:
                case 8:
                    sb.append(digit);
                    break;
                case 2:
                    sb.append(5);
                    break;
                case 5:
                    sb.append(2);
                    break;
                case 6:
                    sb.append(9);
                    break;
                case 9:
                    sb.append(6);
                    break;
                default:
                    return false;
            }
            N /= 10;
        }
        return num != Integer.valueOf(sb.reverse().toString());
    }

    public static void main(String[] args) {

        System.out.println(rotatedDigits(10));

    }

}
