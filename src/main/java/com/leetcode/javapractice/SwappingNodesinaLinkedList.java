package com.leetcode.javapractice;

public class SwappingNodesinaLinkedList {

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = null;
        ListNode n2 = null;
        for (ListNode p = head; p != null; p = p.next) {
            n2 = n2 == null ? null : n2.next;
            if (--k == 0) {
                n1 = p;
                n2 = head;
            }
        }
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        swapNodes(head, 2);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
