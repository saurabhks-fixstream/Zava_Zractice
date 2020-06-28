package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ReconstructItinerary {

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<String, PriorityQueue<String>>();
        for (List<String> ticket : tickets) {
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<String>()).add(ticket.get(1));
        }
        LinkedList<String> route = new LinkedList<String>();
        Stack<String> stack = new Stack<String>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty()) {
                stack.push(targets.get(stack.peek()).poll());
            }
            route.addFirst(stack.pop());
        }
        return route;
    }

    public static void main(String[] args) {

        List<List<String>> tickets = new ArrayList<List<String>>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        System.out.println(findItinerary(tickets));

    }

}
