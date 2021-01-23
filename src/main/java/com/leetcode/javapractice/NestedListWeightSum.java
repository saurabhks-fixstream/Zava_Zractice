package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

interface NestedInteger {

    boolean isInteger();

    Integer getInteger();

    void setInteger(int value);

    void add(NestedInteger ni);

    List<NestedInteger> getList();
}

public class NestedListWeightSum {

    public static int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        int sum = 0;
        int level = 1;
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger ni = queue.poll();
                if (ni.isInteger()) {
                    sum += ni.getInteger() * level;
                } else {
                    queue.addAll(ni.getList());
                }
            }
            level++;
        }
        return sum;
    }

    public static void main(String[] args) {

        List<NestedInteger> nestedList = new ArrayList<NestedInteger>();
        System.out.println(depthSum(nestedList));
    }
}
