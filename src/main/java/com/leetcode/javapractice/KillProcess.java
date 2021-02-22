package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KillProcess {

    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (kill == 0) {
            return pid;
        }
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        for (int p : ppid) {
            graph.put(p, new HashSet<Integer>());
        }
        for (int i = 0; i < pid.size(); i++) {
            graph.get(ppid.get(i)).add(pid.get(i));
        }
        killProcessHelper(graph, result, kill);
        return result;
    }

    private static void killProcessHelper(
            Map<Integer, Set<Integer>> tree, List<Integer> result, int pid) {
        result.add(pid);
        Set<Integer> children = tree.getOrDefault(pid, new HashSet<Integer>());
        for (Integer child : children) {
            killProcessHelper(tree, result, child);
        }
    }

    public static void main(String[] args) {

        List<Integer> pid = Arrays.asList(1);
        List<Integer> ppid = Arrays.asList(0);
        System.out.println(killProcess(pid, ppid, 1));
    }
}
