package com.algorithm.offer.tree;

import com.algorithm.leetcode.stack.TreeNode;

/**
 * 剑指offer 二叉树的深度
 */

public class Solution1 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int max = Integer.MIN_VALUE;
        if (root.left != null) {
            Math.max(max, TreeDepth(root.left));
        }
        if (root.right != null) {
            Math.max(max, TreeDepth(root.right));
        }
        return max;
    }

}
