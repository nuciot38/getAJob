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
    //给链表赋值
    public ListNode init(){
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(0);
        ListNode node = listNode;
        for (int i=0;i<nums.length;i++){
            node.next = new ListNode(nums[i]);
        }
        return listNode;
    }

    //尾插法
    public ListNode insert(ListNode root, ListNode node){
        root.next = node;
        return root;
    }

    //头插法
//    public ListNode insertInHead(ListNode root, ListNode node){
//
//    }
}
