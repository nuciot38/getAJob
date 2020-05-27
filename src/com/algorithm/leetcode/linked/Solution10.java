package com.algorithm.leetcode.linked;

/**
 * LeetCode 25 K个一组翻转链表
 */
public class Solution10 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode pre = dumpy, end = dumpy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dumpy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
