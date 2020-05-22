package com.leetcode.tree;

import com.leetcode.stack.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * LeetCode 106 从中序与后序遍历序列构造二叉树
 */
public class Solution11 {
    int[] inorder;
    int[] postorder;
    int post_idx = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        Solution11 solution11 = new Solution11();
        solution11.buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        post_idx = postorder.length-1;
        int idx = 0;
        for (int val : inorder) {
            map.put(val, idx++);
        }
        return helper(0, inorder.length);
    }

    public TreeNode helper(int left, int right) {
        if (left == right) {
            return null;
        }
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        int index = map.get(root_val);
        post_idx--;
        root.right = helper(index+1, right);
        root.left = helper(left, index);
        return root;
    }
}
