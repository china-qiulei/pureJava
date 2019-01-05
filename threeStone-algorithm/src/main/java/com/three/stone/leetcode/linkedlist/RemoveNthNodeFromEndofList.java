package com.three.stone.leetcode.linkedlist;

import com.three.stone.leetcode.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 *
 */
public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head, node2 = head;

        while (n-- > 0) {
            node1 = node1.next;
        }

        /**
         * n == 链表长度的场景
         */
        if (node1 == null) {
            return node2.next;
        }

        /**
         * node2保持在待删除节点的前一位，方便删除
         */
        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }

        node2.next = node2.next.next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        /**
         * 增加一个哨兵
         */
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode p = sentinel, q = sentinel;

        /**
         * 向后移动n+1次
         */
        while ((n--) >= 0) {
            p = p.next;
        }

        while (p != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return sentinel.next;
    }
}
