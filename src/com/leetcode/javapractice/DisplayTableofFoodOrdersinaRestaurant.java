package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DisplayTableofFoodOrdersinaRestaurant {

    public static List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<Integer, Map<String, Integer>> tableMap = new TreeMap<Integer, Map<String, Integer>>();
        Set<String> dishes = new TreeSet<String>();
        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            if (!tableMap.containsKey(tableNumber)) {
                tableMap.put(tableNumber, new TreeMap<String, Integer>());
            }
            Map<String, Integer> map = tableMap.get(tableNumber);
            String dish = order.get(2);
            map.put(dish, map.getOrDefault(dish, 0) + 1);
            dishes.add(dish);
        }
        List<String> list = new ArrayList<>();
        list.add("Table");
        list.addAll(dishes);
        result.add(list);
        for (Entry<Integer, Map<String, Integer>> entry : tableMap.entrySet()) {
            List<String> l = new ArrayList<>();
            l.add(String.valueOf(entry.getKey()));
            for (String dish : dishes) {
                l.add(String.valueOf(entry.getValue().getOrDefault(dish, 0)));
            }
            result.add(l);
        }
        return result;
    }

    public static void main(String[] args) {

        String[][] order =
                {{"David", "3", "Ceviche"}, {"Corina", "10", "Beef Burrito"}, {"David", "3", "Fried Chicken"},
                        {"Carla", "5", "Water"}, {"Carla", "5", "Ceviche"}, {"Rous", "3", "Ceviche"}};
        List<List<String>> orders = new ArrayList<List<String>>();
        for (String[] s : order) {
            List<String> list = new ArrayList<String>();
            for (String o : s) {
                list.add(o);
            }
            orders.add(list);
        }
        System.out.println(displayTable(orders));

    }

}
