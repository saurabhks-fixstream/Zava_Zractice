package com.crackingthecodinginterview.JavaPractice;

public class Intersection {

    public static ListNode findIntersection(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null) ? headB
                            : a.next;
            b = (b == null) ? headA
                            : b.next;
        }
        return a;
    }

    public static void main(String[] args) {

        ListNode headA = new ListNode(1);
        ListNode node1 = new ListNode(2);
        headA.next = node1;
        ListNode headB = new ListNode(3);
        ListNode node2 = new ListNode(4);
        headB.next = node2;
        ListNode node3 = new ListNode(5);
        node1.next = node3;
        node2.next = node3;
        ListNode node4 = new ListNode(6);
        node3.next = node4;
        ListNode head = findIntersection(headA, headB);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();

    }

}
