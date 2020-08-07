package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class HTMLEntityParser {

    public static String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        Map<String, Character> map = new HashMap<String, Character>();
        map.put("&quot;", '"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (text.charAt(i) == '&') {
                int j = i;
                while (text.charAt(i) != ';') {
                    i++;
                }
                String s = text.substring(j, i + 1);
                if (map.containsKey(s)) {
                    sb.append(map.get(s));
                } else {
                    sb.append(s);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(entityParser("&amp; is an HTML entity but &ambassador; is not."));
    }
}
