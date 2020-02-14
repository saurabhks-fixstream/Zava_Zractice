package com.leetcode.javapractice;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode currOdd = odd;
        ListNode currEven = even;
        int i = 1;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            if (i % 2 != 0) {
                currOdd.next = temp;
                currOdd = currOdd.next;
            } else {
                currEven.next = temp;
                currEven = currEven.next;
            }
            i++;
        }
        currOdd.next = even.next;
        return odd.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = oddEvenList(head);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }

    }

}
