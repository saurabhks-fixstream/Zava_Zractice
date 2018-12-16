package com.leetcode.javapractice;

public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode len = head;
        int length = 0;
        while (len != null) {
            length++;
            len = len.next;
        }
        k %= length;
        ListNode slowptr = head;
        ListNode fastptr = head;
        while (k > 0) {
            fastptr = fastptr.next;
            if (fastptr == null) {
                fastptr = head;
            }
            k--;
        }
        while (fastptr.next != null) {
            slowptr = slowptr.next;
            fastptr = fastptr.next;
        }
        if (slowptr.next != null) {
            ListNode temp = slowptr.next;
            slowptr.next = null;
            fastptr.next = head;
            head = temp;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 200000000;
        head = rotateRight(head, k);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();

    }

}
