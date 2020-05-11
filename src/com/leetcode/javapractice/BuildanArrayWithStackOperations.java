package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class BuildanArrayWithStackOperations {

    public static List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<String>();
        int j = 1;
        for (int i = 0; i < target.length; i++) {
            if (target[i] == j) {
                result.add("Push");
                j++;
            } else {
                result.add("Push");
                result.add("Pop");
                j++;
                i--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] target = { 1, 3 };
        System.out.println(buildArray(target, 3));

    }

}
