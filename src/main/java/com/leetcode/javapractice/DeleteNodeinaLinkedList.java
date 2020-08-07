package com.leetcode.javapractice;

public class DeleteNodeinaLinkedList {

    public static void deleteNode(ListNode node) {
        if (node.next == null) {
            return;
        } else {
            ListNode temp = node;
            ListNode prev = null;
            while (temp.next != null) {
                temp.val = temp.next.val;
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        deleteNode(node2);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
