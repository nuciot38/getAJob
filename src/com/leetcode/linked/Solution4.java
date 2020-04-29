package com.leetcode.linked;


/**
 * LeetCode 61 旋转链表
 */
public class Solution4 {

    public ListNode test(ListNode head){
        ListNode node = head;
        while (node .next != null){
            node = node.next;
        }
        node.next = head;
        ListNode res = head;
        node.next = null;
        return res;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;
        new_tail.next = null;
        return new_head;
    }
}
