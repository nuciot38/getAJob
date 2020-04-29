package com.leetcode.linked;

/**
 * LeetCode 206 反转链表
 */

public class Solution6 {
    public ListNode reverseList(ListNode head) {
        ListNode listNode = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = listNode;
            listNode = curr;
            curr = temp;
        }
        return listNode;
    }
}
