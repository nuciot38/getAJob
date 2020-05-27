package com.algorithm.leetcode.tree;

import com.algorithm.leetcode.stack.TreeNode;

public class Solution8 {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer upper){
        if (root == null){
            return true;
        }
        int val = root.val;
        if (lower != null && lower >= val){
            return false;
        }
        if (upper != null && upper <= val){
            return false;
        }
        if (!helper(root.right, val, upper)){
            return false;
        }
        if (!helper(root.left, lower, val)){
            return false;
        }
        return true;
    }

}
