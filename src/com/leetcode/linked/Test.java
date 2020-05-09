package com.leetcode.linked;

public class Test {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode next = listNode;
        System.out.println(listNode.hashCode());
        System.out.println(next.hashCode());
        System.out.println(System.identityHashCode(listNode));
        System.out.println(System.identityHashCode(next));
        for (int i=0;i<10;i++){
            next.next = new ListNode(i);
            listNode.next = next;
        }
        int a = 0;
    }
}
