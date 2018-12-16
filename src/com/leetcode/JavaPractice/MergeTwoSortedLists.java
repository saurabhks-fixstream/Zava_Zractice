package com.leetcode.JavaPractice;

public class MergeTwoSortedLists {

    private static ListNode insert(ListNode l1, ListNode current) {
        ListNode temp = l1;
        ListNode previous = null;
        while (temp != null) {
            if (temp.val < current.val) {
                previous = temp;
                temp = temp.next;
            } else {
                break;
            }
        }
        if (temp == l1) {
            current.next = l1;
            l1 = current;
        } else if (temp == null) {
            previous.next = current;
        } else {
            ListNode temp1 = previous.next;
            previous.next = current;
            current.next = temp1;
        }
        return l1;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode current = l2;
        ListNode previous = null;
        while (current != null) {
            previous = current;
            current = current.next;
            previous.next = null;
            l1 = insert(l1, previous);
        }
        return l1;
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
