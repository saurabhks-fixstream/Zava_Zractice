package com.leetcode.javapractice;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(4);
        head1.next = node0;
        node0.next = node1;
        node1.next = null;
        ListNode head2 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        head2.next = node2;
        node2.next = node3;
        node3.next = null;
        ListNode head = mergeTwoLists(head1, head2);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();

    }

}
