package com.crackingthecodinginterview.javapractice;

public class ReturnKthToLast {

    public static ListNode kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        int k = 3;
        ListNode kth = kthToLast(head, k);
        System.out.println(kth.val);
    }
}
