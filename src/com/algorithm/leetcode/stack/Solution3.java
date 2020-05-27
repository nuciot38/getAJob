package com.algorithm.leetcode.stack;

import java.util.*;

/**
 * LeetCode 103 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Solution3 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        LinkedList<Integer> linkedList = new LinkedList<>();
        boolean isOrder = true;

        while (queue.size() > 0) {
            TreeNode node = queue.pollFirst();
            if (node != null) {
                if (isOrder){
                    linkedList.addLast(node.val);
                }else {
                    linkedList.addFirst(node.val);
                }
                if (node.left != null){
                    queue.addLast(node.left);
                }
                if (node.right != null){
                    queue.addLast(node.right);
                }
            }else {
                result.add(linkedList);
                linkedList = new LinkedList<>();
                if (queue.size()>0){
                    queue.addLast(null);
                }
                isOrder = !isOrder;
            }

        }
        return result;
    }

}
