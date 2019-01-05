package com.three.stone.leetcode.linkedlist;

import com.three.stone.leetcode.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list
 * where tail connects to. If pos is -1, then there is no cycle in the linked list.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, quick = head;
        while (slow != null && quick != null && quick.next != null) {
            if (slow.next == quick.next.next) {
                return true;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return false;
    }
}
