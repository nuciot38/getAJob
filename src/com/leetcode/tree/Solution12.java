package com.leetcode.tree;

import com.leetcode.stack.TreeNode;

/**
 * LeetCode 222 完全二叉树的节点个数
 */
public class Solution12 {
    public int countNodes(TreeNode root) {
        return root != null ? 1 + countNodes(root.left) + countNodes(root.right) : 0;
    }
}
