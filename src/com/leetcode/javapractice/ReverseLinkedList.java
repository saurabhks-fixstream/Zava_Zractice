package com.leetcode.javapractice;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode dummyc = dummy;
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            if (temp.next != null) {
                prev = temp;
                temp = temp.next;
            } else {
                if (prev.next != null) {
                    dummy.next = prev.next;
                    dummy = dummy.next;
                    prev.next = null;
                    temp = head;
                } else {
                    dummy.next = head;
                    temp = null;
                }
            }
        }
        return dummyc.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = reverseList(head);
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("]");

    }

}
