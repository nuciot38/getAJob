package com.algorithm.leetcode.bfs;

import com.algorithm.leetcode.stack.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 199 二叉树的右视图
 * 广度优先搜索，保留每层最后一个结点的值
 */

public class Solution1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()){
            int size = treeNodes.size();
            for (int i=0;i<size;i++){
                TreeNode node = treeNodes.poll();
                if (node.left != null){
                    treeNodes.offer(node.left);
                }
                if (node.right != null){
                    treeNodes.offer(node.right);
                }
                if (i == size-1){
                    list.add(node.val);
                }
            }
        }
        return list;
    }
}
