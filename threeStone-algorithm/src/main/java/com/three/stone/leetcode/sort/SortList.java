package com.three.stone.leetcode.sort;

import com.three.stone.leetcode.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * 1 2 4  3  7
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinel = middle(head, null);
        return sentinel.next;
    }

    public ListNode middle(ListNode head, ListNode tail) {
        if (head.next == tail || head == tail) {
            return head;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode i = sentinel, j = head;
        int midValue = head.val;
        while (j.next != tail) {
            if (j.val < midValue) {
                ListNode temp = j.next;
                j.next = j.next.next;
                temp.next = i.next;
                i.next = temp;
                i = i.next;
            } else {
                j = j.next;
            }
        }
        i.next.val = midValue;

        middle(sentinel.next, i.next);
        middle(i.next, null);
        return sentinel.next;
    }
}
