package com.crackingthecodinginterview.javapractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BuildOrder {

    private static void findBuildOrderHelper(LinkedList<Integer>[] adj, int v, boolean[] visited,
                                             Stack<Integer> stack) {
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj[v].listIterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                findBuildOrderHelper(adj, i, visited, stack);
            }
        }
        stack.push(v);
    }

    public static List<Integer> findBuildOrder(LinkedList<Integer>[] adj) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if (visited[i] == false) {
                findBuildOrderHelper(adj, i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {

        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] adj = new LinkedList[6];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        adj[0].add(3);
        adj[5].add(1);
        adj[1].add(3);
        adj[5].add(0);
        adj[3].add(2);
        List<Integer> list = findBuildOrder(adj);
        System.out.println(list);

    }

}
