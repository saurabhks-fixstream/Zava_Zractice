package com.leetcode.javapractice;

public class SortList {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeList(l1, l2);
    }

    private static ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode prev = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return result.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head = sortList(head);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }
}
