package com.offer.tree;

import com.leetcode.stack.TreeNode;

/**
 * 剑指offer 镜像二叉树
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 */

public class Solution2 {
    public void Mirror(TreeNode root){
        if (root == null || (root.left == null && root.right == null)){
            return ;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if (root.left != null){
            Mirror(root.left);
        }
        if (root.right != null){
            Mirror(root.right);
        }
    }

}
