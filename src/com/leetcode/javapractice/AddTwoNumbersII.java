package com.leetcode.javapractice;

import java.util.Stack;

public class AddTwoNumbersII {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        int carry = 0;
        ListNode dummy = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int x = (!stack1.isEmpty()) ? stack1.pop()
                                        : 0;
            int y = (!stack2.isEmpty()) ? stack2.pop()
                                        : 0;
            sum = x + y + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            temp.next = dummy;
            dummy = temp;
        }
        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            temp.next = dummy;
            dummy = temp;
        }
        return dummy;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l = addTwoNumbers(l1, l2);
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
        System.out.println();

    }

}
