package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class JumpGameIV {

    public static int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = n - 1; i >= 0; i--) {
            map.putIfAbsent(arr[i], new LinkedList<Integer>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int j = queue.poll();
                if (j + 1 < n && map.containsKey(arr[j + 1])) {
                    if (j + 1 == n - 1) {
                        return res;
                    }
                    queue.offer(j + 1);
                }
                if (j - 1 >= 0 && map.containsKey(arr[j - 1])) {
                    queue.offer(j - 1);
                }
                if (map.containsKey(arr[j])) {
                    for (int k : map.get(arr[j])) {
                        if (k != j) {
                            if (k == n - 1) {
                                return res;
                            }
                            queue.offer(k);
                        }
                    }
                    map.remove(arr[j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(minJumps(arr));
    }
}
