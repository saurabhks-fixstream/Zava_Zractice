package com.crackingthecodinginterview.javapractice;

public class DeleteMiddleNode {

    public static void deleteNode(ListNode node) {
        if (node.next == null || node == null) {
            return;
        }
        ListNode prev = null;
        while (node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        deleteNode(head.next.next);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
