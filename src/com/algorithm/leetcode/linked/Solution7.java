package com.algorithm.leetcode.linked;


/**
 * LeetCode 92 反转链表II
 */
public class Solution7 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        ListNode root = new ListNode(0);
        ListNode node = root;
        for (int i=0;i<arr.length;i++){
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
//        ListNode one = new ListNode(32);
//        ListNode dumpy = new ListNode(0);
//        dumpy.next = root.next;
//        while (dumpy != null){
//            if (dumpy.val == 3){
//                one.next = dumpy.next;
//                dumpy.next = one;
//                break;
//            }else {
//                dumpy = dumpy.next;
//            }
//        }
        Solution7 solution7 = new Solution7();
        solution7.reverseBetween(root.next, 3, 5);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode p1 = dumpy, p2 = dumpy.next;
        int step = 0;
        while (step < m - 1) {
            p1 = p1.next;
            p2 = p2.next;
            step++;
        }
        //头插法
        for (int i = 0; i < n - m; i++) {
            ListNode temp = p2.next;
            p2.next = p2.next.next;
            temp.next = p1.next;
            p1.next = temp;
        }
        return dumpy.next;
    }


    //官方题解
    private boolean stop;
    private ListNode left;

    public void recurseAndReverse(ListNode right, int m, int n) {
        if (n == 1) {
            return;
        }
        right = right.next;
        if (m > 1) {
            this.left = this.left.next;
        }
        this.recurseAndReverse(right, m - 1, n - 1);
        if (this.left == right || this.left == right.next) {
            this.stop = true;
        }
        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;
            this.left = this.left.next;
        }
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }
}
