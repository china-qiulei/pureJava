package com.three.stone.leetcode.linkedlist;

import com.three.stone.leetcode.ListNode;

/**
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head.next;
        head.next = null;

        while (p != null) {
            ListNode q = p.next;
            p.next = head;
            head = p;
            p = q;
        }
        return head;
    }
}
