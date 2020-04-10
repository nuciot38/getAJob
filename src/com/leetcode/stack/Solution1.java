package com.leetcode.stack;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 94 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序遍历。
 */

public class Solution1 {

    /**
     * 二叉树中序遍历顺序为：左->根->右
     * 最简单的方式为递归
     * 复杂方法有莫里斯遍历，暂未研究
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getTree(root, list);
        return list;
    }

    public void getTree(TreeNode root, List<Integer> list){
        if (root != null){
            if (root.left != null){
                getTree(root.left, list);
            }
            list.add(root.val);
            if (root.right != null){
                getTree(root.right, list);
            }
        }
    }
}
