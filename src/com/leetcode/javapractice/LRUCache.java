package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

class DoublyLinkedListNode {

    int key;
    int value;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

}

public class LRUCache {

    Map<Integer, DoublyLinkedListNode> cache = new HashMap<Integer, DoublyLinkedListNode>();
    DoublyLinkedListNode head = new DoublyLinkedListNode(0, 0);
    DoublyLinkedListNode tail = new DoublyLinkedListNode(0, 0);
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DoublyLinkedListNode node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        if (cache.size() == capacity) {
            remove(tail.prev);
        }
        insert(new DoublyLinkedListNode(key, value));
    }

    public void insert(DoublyLinkedListNode node) {
        cache.put(node.key, node);
        DoublyLinkedListNode headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    public void remove(DoublyLinkedListNode node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

}
