package com.leetcode.recall;

import java.util.*;

/**
 * LeetCode 40 组合总数II
 */
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = solution4.combinationSum2(candidates, target);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        int len = candidates.length;
        backtrack(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    public void backtrack(int[] candidates, int len, int resduse, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (resduse == 0) {
            List<Integer> cur = new ArrayList<>(path);
            res.add(cur);
            return;
        }
        for (int i = begin; i < len; i++) {
            if (resduse - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            backtrack(candidates, len, resduse - candidates[i], i + 1, path, res);
            path.removeLast();
        }
    }
}
