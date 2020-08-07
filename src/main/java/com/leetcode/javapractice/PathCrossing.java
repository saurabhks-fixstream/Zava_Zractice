package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathCrossing {

    public static boolean isPathCrossing(String path) {
        Map<Character, int[]> dirs = new HashMap<Character, int[]>();
        dirs.put('N', new int[] {0, 1});
        dirs.put('S', new int[] {0, -1});
        dirs.put('E', new int[] {1, 0});
        dirs.put('W', new int[] {-1, 0});
        Set<String> visited = new HashSet<String>();
        visited.add(0 + "$" + 0);
        int x = 0;
        int y = 0;
        for (char c : path.toCharArray()) {
            x += dirs.get(c)[0];
            y += dirs.get(c)[1];
            String point = x + "$" + y;
            if (visited.contains(point)) {
                return true;
            } else {
                visited.add(point);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(isPathCrossing("NES"));
    }
}
