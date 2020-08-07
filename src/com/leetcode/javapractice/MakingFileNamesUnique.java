package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class MakingFileNamesUnique {

    public static String[] getFolderNames(String[] names) {
        String[] result = new String[names.length];
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < names.length; i++) {
            if (map.containsKey(names[i])) {
                int num = map.get(names[i]);
                String str = names[i] + "(" + num + ")";
                while (map.containsKey(str)) {
                    num++;
                    str = names[i] + "(" + num + ")";
                }
                map.put(names[i], num);
                result[i] = str;
                map.put(str, map.getOrDefault(str, 0) + 1);
            } else {
                result[i] = names[i];
            }
            map.put(names[i], map.getOrDefault(names[i], 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {

        String[] names = {"pes", "fifa", "gta", "pes(2019)"};
        String[] result = getFolderNames(names);
        for (String r : result) {
            System.out.print(r + " ");
        }

    }

}
