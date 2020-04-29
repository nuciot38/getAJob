package com.leetcode.linked;

/**
 * LeetCode 19 删除链表的倒数第n个节点
 */
public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode start = listNode, end = listNode;
        while(n != 0){
            start = start.next;
            n--;
        }
        while (start.next != null){
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return listNode.next;
    }
}
