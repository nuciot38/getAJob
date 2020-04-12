package com.leetcode.tree;

import com.leetcode.stack.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 111 二叉树的最小深度
 */

public class Solution1 {
    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if(root.left != null){
            min = Math.min(min, run(root.left));
        }
        if(root.right != null){
            min = Math.min(min, run(root.right));
        }
        return min + 1;
    }
}
