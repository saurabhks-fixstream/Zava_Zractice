package com.leetcode.JavaPractice;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0, carry = 0;
        ListNode number = new ListNode(0);
        ListNode temp = number;
        while (l1 != null || l2 != null) {
            sum = ((l1 != null) ? l1.val
                                : 0)
                  + ((l2 != null) ? l2.val
                                  : 0)
                  + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return number.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        ListNode l = addTwoNumbers(l1, l2);
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
        System.out.println();

    }

}
