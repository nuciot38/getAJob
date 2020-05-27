package com.algorithm.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 144 二叉树的前序遍历
 * 给定一个二叉树，返回它的前序遍历
 */

public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getTree(root, list);
        return list;
    }

    /**
     * 二叉树前序遍历顺序为根->左->右
     */
    public void getTree(TreeNode root, List<Integer> list){
        if(root != null){
            list.add(root.val);
            if(root.left != null){
                getTree(root.left, list);
            }
            if(root.right != null){
                getTree(root.right, list);
            }
        }
    }
}