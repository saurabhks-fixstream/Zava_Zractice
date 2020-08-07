package com.leetcode.javapractice;

public class RemoveNthNodeFromEndofList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode previous = null;
        ListNode slowptr = head;
        ListNode fastptr = head;
        while (n > 0 && fastptr != null) {
            fastptr = fastptr.next;
            n--;
        }
        while (fastptr != null) {
            previous = slowptr;
            slowptr = slowptr.next;
            fastptr = fastptr.next;
        }
        if (previous != null) {
            previous.next = previous.next.next;
        } else {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        int n = 2;
        head = removeNthFromEnd(head, n);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
