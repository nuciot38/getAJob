package com.algorithm.leetcode.linked;

/**
 * LeetCode 24 两两交换链表中的节点
 */
public class Solution3 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode node = listNode;
        while (head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;

            node.next = second;
            first.next = second.next;
            second.next = first;

            node = first;
            head = first.next;
        }
        return listNode.next;
    }
}
