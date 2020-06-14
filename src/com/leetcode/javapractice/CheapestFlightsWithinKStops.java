package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] flight : flights) {
            if (!prices.containsKey(flight[0])) {
                prices.put(flight[0], new HashMap<>());
            }
            prices.get(flight[0]).put(flight[1], flight[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[] { 0, src, K + 1 });
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) {
                return price;
            }
            if (stops > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[] { price + adj.get(a), a, stops - 1 });
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
        System.out.println(findCheapestPrice(3, flights, 0, 2, 1));

    }

}
