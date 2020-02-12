package com.leetcode.javapractice;

public class DesignLinkedList {

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

        /** Initialize your data structure here. */
        public MyLinkedList() {

        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
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

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will
         * be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode temp = head;
            head = new ListNode(val);
            head.next = temp;
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
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

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
         * list, the node will be appended to the end of linked list. If index is greater than the length, the node will
         * not be inserted.
         */
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

        /** Delete the index-th node in the linked list, if the index is valid. */
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
}
