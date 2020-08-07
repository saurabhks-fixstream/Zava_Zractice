package com.leetcode.javapractice;

class MyLinkedList {

    private class ListNode {

        private int val;
        private ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private ListNode head;
    private int size;

    public MyLinkedList() {}

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        ListNode temp = head;
        head = new ListNode(val);
        head.next = temp;
        size++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else {
            size++;
            ListNode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            ListNode node = new ListNode(val);
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
        } else {
            ListNode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }
}

public class DesignLinkedList {

    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList.get(1));
    }
}
