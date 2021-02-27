package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Relation {

    static Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

    static {
        graph.put(0, Arrays.asList(1));
        graph.put(1, new ArrayList<Integer>());
        graph.put(2, Arrays.asList(1, 2));
    }

    public static boolean knows(int a, int b) {
        return graph.get(a).contains(b);
    }
}

public class FindtheCelebrity extends Relation {

    public static int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) candidate = i;
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {

        System.out.println(findCelebrity(3));
    }
}
