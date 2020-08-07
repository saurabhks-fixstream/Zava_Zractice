package com.crackingthecodinginterview.javapractice;

import java.util.HashMap;
import java.util.Map;

public class OneAway {

    public static boolean oneEditAway(String first, String second) {
        int difference = Math.abs(first.length() - second.length());
        if (difference > 1) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < first.length(); i++) {
            if (!map.containsKey(first.charAt(i))) {
                map.put(first.charAt(i), 1);
            } else {
                map.put(first.charAt(i), (map.get(first.charAt(i)) + 1));
            }
        }
        int count = 0;
        for (int i = 0; i < second.length(); i++) {
            if (map.containsKey(second.charAt(i)) && map.get(second.charAt(i)) != 0) {
                map.put(second.charAt(i), (map.get(second.charAt(i)) - 1));
                count++;
            }
        }
        int diff = first.length() > second.length() ? first.length()
                : second.length();
        if (count == diff || count == diff - 1 || count == diff + 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(oneEditAway("mmn", "mnn"));

    }

}
