package com.algorithm.leetcode.recall;

import java.util.*;

/**
 * LeetCode 39 组合总数I
 */
public class Solution3 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        int len = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    public void dfs(int[] candidates, int len, int residue, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (residue - candidates[i]< 0){
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, len, residue-candidates[i], i, path, res);
            path.removeLast();
        }
    }
}
