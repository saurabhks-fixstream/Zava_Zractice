package com.leetcode.JavaPractice;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fastptr = head;
        ListNode slowptr = head;
        while (slowptr != null && fastptr != null && fastptr.next != null) {
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            if (slowptr == fastptr) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        System.out.println(hasCycle(head));

    }

}
