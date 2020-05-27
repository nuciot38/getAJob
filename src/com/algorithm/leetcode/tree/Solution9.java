package com.algorithm.leetcode.tree;

import com.algorithm.leetcode.stack.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 236 二叉树的最近公共祖先
 */
public class Solution9 {
    //递归
    private TreeNode ans;

    public Solution9() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return ans;
    }

    //存储父节点
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        dfs(root);
        while (p != null){
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while(q != null){
            if (visited.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}
