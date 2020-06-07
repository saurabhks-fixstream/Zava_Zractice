package com.leetcode.javapractice;

public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = reverseList(slow.next);
        slow.next = null;
        while (head != null && head2 != null) {
            ListNode temp1 = head.next;
            ListNode temp2 = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = temp1;
            head2 = temp2;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        reorderList(head);
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("]");

    }

}
