package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ParallelCourses {

    public static int minimumSemesters(int N, int[][] relations) {
        Map<Integer, List<Integer>> g = new HashMap<Integer, List<Integer>>();
        int[] inDegree = new int[N + 1];
        for (int[] r : relations) {
            g.computeIfAbsent(r[0], l -> new ArrayList<Integer>()).add(r[1]);
            ++inDegree[r[1]];
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= N; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int semester = 0;
        while (!queue.isEmpty()) {
            for (int sz = queue.size(); sz > 0; --sz) {
                int c = queue.poll();
                --N;
                if (!g.containsKey(c)) {
                    continue;
                }
                for (int course : g.remove(c)) {
                    if (--inDegree[course] == 0) {
                        queue.offer(course);
                    }
                }
            }
            ++semester;
        }
        return N == 0 ? semester : -1;
    }

    public static void main(String[] args) {

        int[][] relations = {{1, 3}, {2, 3}};
        System.out.println(minimumSemesters(3, relations));
    }
}
