package com.leetcode.javapractice;

import java.util.Arrays;

public class BagofTokens {

    public static int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int result = 0;
        int points = 0;
        int i = 0;
        int j = tokens.length - 1;
        while (i <= j) {
            if (P >= tokens[i]) {
                P -= tokens[i++];
                result = Math.max(result, ++points);
            } else if (points > 0) {
                points--;
                P += tokens[j--];
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] tokens = {100};
        System.out.println(bagOfTokensScore(tokens, 50));
    }
}
