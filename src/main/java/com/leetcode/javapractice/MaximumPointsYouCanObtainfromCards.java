package com.leetcode.javapractice;

public class MaximumPointsYouCanObtainfromCards {

    public static int maxScore(int[] cardPoints, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int window = cardPoints.length - k;
        int windowSum = 0;
        for (int cardPoint : cardPoints) {
            sum += cardPoint;
        }
        for (int i = 0; i < window; i++) {
            windowSum += cardPoints[i];
        }
        for (int i = 0; i + window < cardPoints.length; i++) {
            max = Math.max(max, sum - windowSum);
            windowSum -= cardPoints[i];
            windowSum += cardPoints[i + window];
        }
        max = Math.max(max, sum - windowSum);
        return max;
    }

    public static void main(String[] args) {

        int[] cardPoints = {96, 90, 41, 82, 39, 74, 64, 50, 30};
        System.out.println(maxScore(cardPoints, 8));
    }
}
