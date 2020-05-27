package com.algorithm.leetcode.recall;

import java.util.*;

/**
 * LeetCode 77 组合
 */
public class Solution7 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        List<List<Integer>> res = solution7.combine(4, 2);
        System.out.println(res);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k) {
            return res;
        }
        helper(n, k, 1, new LinkedList<>(), res);
        return res;
    }

    public void helper(int n, int k, int start, LinkedList<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            helper(n, k, i+1, path, res);
            path.removeLast();
        }
    }
}
