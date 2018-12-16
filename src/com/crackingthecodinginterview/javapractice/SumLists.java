package com.crackingthecodinginterview.javapractice;

public class SumLists {

    public static ListNode addLists(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode dummy = dummyHead;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val
                                 : 0;
            int y = (l2 != null) ? l2.val
                                 : 0;
            sum = x + y + carry;
            carry = sum / 10;
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            dummy.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(2);
        ListNode l = addLists(l1, l2);
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
        System.out.println();

    }

}
