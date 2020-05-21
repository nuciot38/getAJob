package com.leetcode.tree;

import com.leetcode.stack.TreeNode;

import java.util.HashMap;

/**
 * LeetCode 105 从前序和中序遍历序列构造二叉树
 */
public class Solution10 {
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode helper(int inleft, int inright){
        if (inleft == inright){
            return null;
        }
        int rootval = preorder[pre_idx];
        TreeNode root = new TreeNode(rootval);
        int index = map.get(rootval);
        pre_idx++;
        root.left = helper(inleft, index);
        root.right = helper(index+1, inright);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder =inorder;
        int idx = 0;
        for (int val : inorder){
            map.put(val, idx++);
        }
        return helper(0, inorder.length);
    }
}
