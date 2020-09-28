package com.leetcode.javapractice;

public class InsertintoaSortedCircularLinkedList {

    public static ListNode insert(ListNode head, int insertVal) {
        if (head == null) {
            head = new ListNode(insertVal);
            head.next = head;
            return head;
        }
        ListNode max = head;
        while (max.val <= max.next.val && max.next != head) {
            max = max.next;
        }
        ListNode min = max.next;
        ListNode curr = min;
        ListNode newNode = new ListNode(insertVal);
        if (insertVal <= min.val || insertVal >= max.val) {
            newNode.next = min;
            max.next = newNode;
        } else {
            while (curr.next.val < insertVal) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(1);
        head.next.next.next = head;
        ListNode curr = insert(head, 2);
        do {
            System.out.print(curr.val + "->");
            curr = curr.next;
        } while (curr != head);
    }
}
