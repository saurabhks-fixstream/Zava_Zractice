package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class KeysandRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack<Integer>();
        dfs.add(0);
        HashSet<Integer> seen = new HashSet<Integer>();
        seen.add(0);
        while (!dfs.isEmpty()) {
            int i = dfs.pop();
            for (int j : rooms.get(i)) {
                if (!seen.contains(j)) {
                    dfs.add(j);
                    seen.add(j);
                    if (rooms.size() == seen.size()) {
                        return true;
                    }
                }
            }
        }
        return rooms.size() == seen.size();
    }

    public static void main(String[] args) {

        List<List<Integer>> rooms = Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3));
        System.out.println(canVisitAllRooms(rooms));
    }
}
