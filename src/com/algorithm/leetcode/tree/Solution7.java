package com.algorithm.leetcode.tree;

import com.algorithm.leetcode.stack.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 95 不同的二叉搜索树II
 */
public class Solution7 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0){
            return result;
        }
        return getAllTrees(1, n);
    }

    public LinkedList<TreeNode> getAllTrees(int start, int end) {
        LinkedList<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> leftTrees = getAllTrees(start, i-1);
            LinkedList<TreeNode> rightTrees = getAllTrees(i+1, end);

            for (TreeNode l : leftTrees){
                for (TreeNode r : rightTrees){
                    TreeNode current = new TreeNode(i);
                    current.left = l;
                    current.right = r;
                    allTrees.add(current);
                }
            }
        }
        return allTrees;
    }
}
