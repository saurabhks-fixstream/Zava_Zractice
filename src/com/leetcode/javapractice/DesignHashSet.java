package com.leetcode.javapractice;

import java.util.LinkedList;

class MyHashSet {

    LinkedList<Integer>[] set;
    int keyRange;

    public MyHashSet() {
        keyRange = 769;
        set = new LinkedList[keyRange];
        for (int i = 0; i < keyRange; i++) {
            set[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int hash = key % keyRange;
        if (set[hash].indexOf(key) == -1) {
            set[hash].addFirst(key);
        }
    }

    public void remove(int key) {
        int hash = key % keyRange;
        set[hash].remove(new Integer(key));
    }

    public boolean contains(int key) {
        int hash = key % keyRange;
        return set[hash].contains(key);
    }
}

public class DesignHashSet {

    public static void main(String[] args) {

        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));

    }

}
