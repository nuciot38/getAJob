package com.algorithm.leetcode.linked;

/**
 * LeetCode 82 删除链表中的重复元素II
 */
public class Solution8 {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        int[] a = new int[]{1, 2, 3, 3, 4, 4, 5};
        int index = 0;
        while(index<a.length){
            temp.next = new ListNode(a[index]);
            temp = temp.next;
            index++;
        }
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.deleteDuplicates(node.next));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode p1 = dumpy, p2 = head;
        int temp = 0;
        while (p1.next != null){
            while(p2.next!= null && p2.next.val == p1.next.val){
                p2 = p2.next;
                temp = 1;
            }
            if (temp == 1){
                p1.next = p2.next;
                p2 = p2.next;
                temp = 0;
            }else{
                p1 = p2;
                if (p2.next != null){
                    p2 = p2.next;
                }
            }
        }
        return dumpy.next;
    }
}
