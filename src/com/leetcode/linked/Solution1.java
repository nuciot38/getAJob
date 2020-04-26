package com.leetcode.linked;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 23 合并K个排序链表
 */
public class Solution1 {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (lists == null || len == 0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(len, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val){
                    return 1;
                }else if (o1.val == o2.val){
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        ListNode dumpy = new ListNode(0);
        ListNode p = dumpy;
        for (ListNode node : lists){
            if (node!= null){
                queue.add(node);
            }
        }
        while(!queue.isEmpty()){
            p.next = queue.poll();
            p = p.next;
            if (p.next != null){
                queue.add(p.next);
            }
        }
        return dumpy.next;
    }

}
