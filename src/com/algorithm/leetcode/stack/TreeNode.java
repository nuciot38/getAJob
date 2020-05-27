package com.algorithm.leetcode.stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int x, TreeNode leftNode, TreeNode rightNode){
        val = x;
        left = leftNode;
        right = rightNode;
    }

}
