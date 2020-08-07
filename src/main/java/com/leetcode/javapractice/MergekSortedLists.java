package com.leetcode.javapractice;

public class MergekSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return partition(lists, 0, lists.length - 1);
    }

    private static ListNode partition(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        }
        int mid = i + (j - i) / 2;
        ListNode left = partition(lists, i, mid);
        ListNode right = partition(lists, mid + 1, j);
        return mergeTwoLists(left, right);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            dummy.next = l1;
            dummy = dummy.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            dummy.next = l2;
            dummy = dummy.next;
            l2 = l2.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);
        ListNode[] lists = new ListNode[3];
        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;
        ListNode head = mergeKLists(lists);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
