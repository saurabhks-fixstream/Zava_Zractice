package com.leetcode.javapractice;

public class ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode curr = head;
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }
        ListNode con = prev;
        ListNode tail = curr;
        while (n > 0) {
            ListNode third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            n--;
        }
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = curr;
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = reverseBetween(head, 2, 4);
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("]");
    }
}
