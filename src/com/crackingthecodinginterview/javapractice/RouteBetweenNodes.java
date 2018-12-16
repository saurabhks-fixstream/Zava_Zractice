package com.crackingthecodinginterview.javapractice;

import java.util.Iterator;
import java.util.LinkedList;

public class RouteBetweenNodes {

    public static boolean search(LinkedList<Integer>[] adj, int start, int end) {
        if (start == end) {
            return true;
        }
        boolean[] visited = new boolean[adj.length];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            Iterator<Integer> i = adj[temp].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (n == end) {
                    return true;
                } else if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] adj = new LinkedList[4];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        adj[0].add(1);
        adj[0].add(2);
        adj[1].add(2);
        adj[2].add(0);
        adj[2].add(3);
        adj[3].add(3);
        System.out.println(search(adj, 1, 0));

    }

}
