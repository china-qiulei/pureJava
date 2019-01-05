package com.three.stone.leetcode.sort;

import com.three.stone.leetcode.ListNode;

/**
 * Sort a linked list using insertion sort.
 *
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition,
 * and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data,
 * finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode p = head.next, q;
        head.next = null;

        while (p != null) {
            int value = p.val;
            q = p.next;
            ListNode r = sentinel;
            while (r.next != null && r.next.val < value) {
                r = r.next;
            }
            p.next = r.next;
            r.next = p;
            p = q;
        }
        return sentinel.next;
    }
}
