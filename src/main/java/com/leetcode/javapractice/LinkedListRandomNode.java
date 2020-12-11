package com.leetcode.javapractice;

import java.util.Random;

public class LinkedListRandomNode {

    ListNode node;
    Random random;
    int size = 0;

    public LinkedListRandomNode(ListNode head) {
        node = head;
        random = new Random();
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
    }

    public int getRandom() {
        int idx = random.nextInt(size);
        ListNode temp = node;
        while (idx-- > 0) {
            temp = temp.next;
        }
        return temp.val;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LinkedListRandomNode linkedListRandomNode = new LinkedListRandomNode(head);
        System.out.println(linkedListRandomNode.getRandom());
        System.out.println(linkedListRandomNode.getRandom());
        System.out.println(linkedListRandomNode.getRandom());
    }
}
