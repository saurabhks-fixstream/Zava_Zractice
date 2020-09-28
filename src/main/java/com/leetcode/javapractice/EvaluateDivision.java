package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EvaluateDivision {

    public static double[] calcEquation(
            List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, Map<String, Double>> graph = new HashMap<String, Map<String, Double>>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            graph.putIfAbsent(u, new HashMap<String, Double>());
            graph.putIfAbsent(v, new HashMap<String, Double>());
            graph.get(u).put(v, values[i]);
            graph.get(v).put(u, 1 / values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            result[i] =
                    calcEquationHelper(
                            graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
        }
        return result;
    }

    private static double calcEquationHelper(
            Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }
        visited.add(start);
        for (Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            if (!visited.contains(neighbour.getKey())) {
                double weight = calcEquationHelper(graph, neighbour.getKey(), end, visited);
                if (weight != -1.0) {
                    return neighbour.getValue() * weight;
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {

        List<List<String>> equations = new ArrayList<List<String>>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<List<String>>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        double[] result = calcEquation(equations, values, queries);
        for (double d : result) {
            System.out.print(d + " ");
        }
    }
}
