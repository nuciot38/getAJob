package com.leetcode.recall;

import com.leetcode.stack.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution6 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(1);
        treeNode.right = new TreeNode(1);
        treeNode.right.right = new TreeNode(1);
        System.out.println(pseudoPalindromicPaths(treeNode));
    }

    public static int pseudoPalindromicPaths(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(root, path, res);
        int count = 0;
        for(int i=0;i<res.size();i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<res.get(i).size();j++){
                set.add(res.get(i).get(j));
            }
            if(set.size()<=1){
                count++;
            }
        }
        return count++;
    }

    public static void helper(TreeNode root, List<Integer> path, List<List<Integer>> res) {
//        if(path.contains(root.val)){
//            path.remove(new Integer(root.val));
//        }else{
//            path.add(root.val);
//        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
//            if(path.size()<=1){
//                res.add(path);
//            }
            res.add(new ArrayList<>(path));
            return;
        }

        if (root.left != null) {
            helper(root.left, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            helper(root.right, path, res);
            path.remove(path.size() - 1);
        }
    }

}