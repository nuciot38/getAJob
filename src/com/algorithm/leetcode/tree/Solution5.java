package com.algorithm.leetcode.tree;

import com.algorithm.leetcode.stack.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode 113 路径总和II
 */
public class Solution5 {
    public static void main(String[] args) {
        System.out.println(3/2);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null || sum <= 0) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        getSum(root, sum, path, result);
        return result;
    }

    public void getSum(TreeNode node, int sum, Deque<Integer> path, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        path.addLast(node.val);
        if (sum == 0 && node.left == null && node.right == null){
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        getSum(node.left, sum, path, result);
        getSum(node.right, sum, path, result);
        path.removeLast();
    }
}
