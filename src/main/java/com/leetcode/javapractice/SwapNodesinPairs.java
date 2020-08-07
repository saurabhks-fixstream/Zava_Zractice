package com.leetcode.javapractice;

public class SwapNodesinPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode newHead = head.next;
        while (current != null && current.next != null) {
            ListNode temp = current;
            current = current.next;
            temp.next = current.next;
            current.next = temp;
            current = temp.next;
            if (current != null && current.next != null) {
                temp.next = current.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head = swapPairs(head);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
