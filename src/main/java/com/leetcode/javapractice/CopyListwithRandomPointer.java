package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

    static Map<NodeRandom, NodeRandom> visitedHash = new HashMap<NodeRandom, NodeRandom>();

    public static NodeRandom copyRandomList(NodeRandom head) {
        if (head == null) {
            return null;
        }
        if (visitedHash.containsKey(head)) {
            return visitedHash.get(head);
        }
        NodeRandom node = new NodeRandom(head.val);
        visitedHash.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    public static void main(String[] args) {

        NodeRandom head = new NodeRandom(7);
        NodeRandom node13 = new NodeRandom(13);
        head.next = node13;
        NodeRandom node11 = new NodeRandom(11);
        node13.next = node11;
        NodeRandom node10 = new NodeRandom(10);
        node11.next = node10;
        NodeRandom node1 = new NodeRandom(1);
        node10.next = node1;
        node13.random = head;
        node11.random = node1;
        node10.random = node11;
        node1.random = head;
        NodeRandom result = copyRandomList(head);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }
}
