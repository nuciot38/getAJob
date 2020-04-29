package com.leetcode.linked;

/**
 * LeetCode 86 分割链表
 */

public class Solution5 {

    public ListNode partition(ListNode head, int x) {
        ListNode before_node = new ListNode(0);
        ListNode before = before_node;
        ListNode after_node = new ListNode(0);
        ListNode after = after_node;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = after_node.next;
        return before_node.next;
    }
}
