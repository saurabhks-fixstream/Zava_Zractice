package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpentheLock {

    public static int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>(Arrays.asList(deadends));
        int depth = -1;
        queue.addAll(Arrays.asList("0000"));
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                if (node.equals(target)) {
                    return depth;
                }
                if (visited.contains(node)) {
                    continue;
                }
                visited.add(node);
                queue.addAll(getSuccessors(node));
            }
        }
        return -1;
    }

    private static List<String> getSuccessors(String str) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < str.length(); i++) {
            res.add(
                    str.substring(0, i)
                            + (str.charAt(i) == '0' ? 9 : str.charAt(i) - '0' - 1)
                            + str.substring(i + 1));
            res.add(
                    str.substring(0, i)
                            + (str.charAt(i) == '9' ? 0 : str.charAt(i) - '0' + 1)
                            + str.substring(i + 1));
        }
        return res;
    }

    public static void main(String[] args) {

        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(openLock(deadends, "0202"));
    }
}
