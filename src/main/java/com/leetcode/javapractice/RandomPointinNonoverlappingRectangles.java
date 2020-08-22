package com.leetcode.javapractice;

import java.util.Random;
import java.util.TreeMap;

public class RandomPointinNonoverlappingRectangles {

    int[][] rects;
    Random random;
    TreeMap<Integer, Integer> map;
    int area;

    public RandomPointinNonoverlappingRectangles(int[][] rects) {
        this.rects = rects;
        random = new Random();
        map = new TreeMap<Integer, Integer>();
        area = 0;
        for (int i = 0; i < rects.length; i++) {
            area += (rects[i][3] - rects[i][1] + 1) * (rects[i][2] - rects[i][0] + 1);
            map.put(area, i);
        }
    }

    public int[] pick() {
        int randInt = random.nextInt(area);
        int key = map.ceilingKey(randInt);
        int[] rect = rects[map.get(key)];
        int x = rect[0] + (key - randInt - 1) % (rect[2] - rect[0] + 1);
        int y = rect[1] + (key - randInt - 1) / (rect[2] - rect[0] + 1);
        return new int[] {x, y};
    }

    public static void main(String[] args) {

        int[][] rects = {{1, 1, 5, 5}};
        RandomPointinNonoverlappingRectangles obj = new RandomPointinNonoverlappingRectangles(rects);
        int[] point = obj.pick();
        System.out.println("[" + point[0] + ", " + point[1] + "]");
        point = obj.pick();
        System.out.println("[" + point[0] + ", " + point[1] + "]");
        point = obj.pick();
        System.out.println("[" + point[0] + ", " + point[1] + "]");
    }
}
