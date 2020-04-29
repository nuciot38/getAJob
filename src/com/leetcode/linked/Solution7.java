package com.leetcode.linked;

/**
 * LeetCode 92 反转链表II
 */
public class Solution7 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode start_node = new ListNode(0);
        ListNode start = start_node;
        ListNode end_node = new ListNode(0);
        ListNode end = end_node;
        ListNode listNode = null;
        ListNode curr = head;
        int flag = 1;
        while (head != null) {
            if (flag < m){
                start.next = head;
                start = start.next;
            }else if (flag > n){
                end.next = head;
                end = end.next;
            }else {
                ListNode temp = head.next;
                curr.next = listNode;
                listNode = curr;
                curr = temp;
            }
            head = head.next;
        }
        end.next = null;
        listNode.next = end_node;
        start.next = listNode;
        return start.next;
    }
}
