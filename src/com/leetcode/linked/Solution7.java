package com.leetcode.linked;

import java.util.List;

/**
 * LeetCode 92 反转链表II
 */
public class Solution7 {
    private boolean stop;
    private ListNode left;

    public void recurseAndReverse(ListNode right, int m, int n){
        if (n == 1){
            return;
        }
        right = right.next;
        if (m > 1){
            this.left = this.left.next;
        }
        this.recurseAndReverse(right, m-1, n-1);
        if (this.left == right || this.left == right.next){
            this.stop = true;
        }
        if (!this.stop){
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;
            this.left = this.left.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }
}
