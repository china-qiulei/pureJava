package com.three.stone.leetcode.linkedlist;

import com.three.stone.leetcode.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos
 * <p>
 * which represents the position (0-indexed) in the linked list where tail connects to.
 * <p>
 * If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Note: Do not modify the linked list.
 *
 *
 *                   a        b
 *          start ------->-------->meeting
 *                       |         |
 *                       <----------
 *                            c
 *                            a + b = n (b + c)
 *  所以，从 start 和 meeting 各自开始一步步的前进，最终会在cycle点处汇合
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode slow = head, quick = head, meeting = null;
        while (slow != null && quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                meeting = slow;
                break;
            }
        }

        if (meeting == null) {
            return null;
        }

        while (head != null && meeting != null) {
            if (head == meeting) {
                return head;
            } else {
                head = head.next;
                meeting = meeting.next;
            }
        }

        return null;
    }
}
