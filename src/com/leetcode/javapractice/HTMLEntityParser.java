package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class HTMLEntityParser {

    /*
     * The special characters and their entities for HTML are:
     * Quotation Mark: the entity is &quot; and symbol character is ".
     * Single Quote Mark: the entity is &apos; and symbol character is '.
     * Ampersand: the entity is &amp; and symbol character is &.
     * Greater Than Sign: the entity is &gt; and symbol character is >.
     * Less Than Sign: the entity is &lt; and symbol character is <.
     * Slash: the entity is &frasl; and symbol character is /.
     */

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
        System.out.println(entityParser(" &amp; &gt; 8|eK8FDRO"));

    }

}
