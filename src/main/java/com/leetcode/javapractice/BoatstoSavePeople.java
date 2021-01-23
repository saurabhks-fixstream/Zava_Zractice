package com.leetcode.javapractice;

import java.util.Arrays;

public class BoatstoSavePeople {

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i;
        int j;
        for (i = 0, j = people.length - 1; i <= j; j--) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
        }
        return people.length - 1 - j;
    }

    public static void main(String[] args) {

        int[] people = {1, 2};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }
}
