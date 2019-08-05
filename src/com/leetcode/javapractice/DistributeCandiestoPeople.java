package com.leetcode.javapractice;

public class DistributeCandiestoPeople {

    public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int count = 1;
        int index = 0;
        while (candies >= 0) {
            if (index == num_people) {
                index = 0;
            }
            if (count <= candies) {
                candies -= count;
            } else {
                result[index] += candies;
                break;
            }
            result[index++] += count++;
        }
        return result;

    }

    public static void main(String[] args) {

        int[] result = distributeCandies(120, 3);
        for (int i : result) {
            System.out.print(i + ",");
        }

    }

}
