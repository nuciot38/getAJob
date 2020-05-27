package com.algorithm.leetcode.tree;

import com.algorithm.leetcode.stack.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));

    }

    public static int sumNumbers(TreeNode root){
        return getNums(root, 0);
    }

    public static int getNums(TreeNode node, int i){
        if (node == null){
            return 0;
        }
        int temp = i * 10 + node.val;
        if (node.left == null && node.right == null){
            return temp;
        }
        return getNums(node.left, temp) + getNums(node.right, temp);
    }

    public static int sumNumbers2(TreeNode root) {
        int sum = 0;
        List<Integer> list = setLeafValue(root, new ArrayList<>());
        for (int i=0;i<list.size();i++){
            sum += list.get(i);
        }
        return sum;
    }

    public static List<Integer> setLeafValue(TreeNode root, List<Integer> list){
        if (root.left == null && root.right == null){
            list.add(root.val);
        }
        if (root.left != null){
            StringBuffer sb = new StringBuffer();
            sb.append(String.valueOf(root.val)+String.valueOf(root.left.val));
            root.left.val = Integer.parseInt(sb.toString());
            setLeafValue(root.left, list);
        }
        if (root.right != null){
            StringBuffer sb = new StringBuffer();
            sb.append(String.valueOf(root.val)+String.valueOf(root.right.val));
            root.right.val = Integer.parseInt(sb.toString());
            setLeafValue(root.right, list);
        }
        return list;
    }
}
