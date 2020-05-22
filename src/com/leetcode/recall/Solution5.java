package com.leetcode.recall;

import java.util.*;

/**
 * LeetCode 47 全排列II
 */
public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[] nums = {3, 3, 0, 3};
        List<List<Integer>> res = solution5.permuteUnique(nums);
        System.out.println(res);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        boolean[] used = new boolean[len];
        backtrack(nums, len, 0, used, new ArrayDeque<>(), res);
        return res;
    }

    public void backtrack(int[] nums, int len, int step, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (step == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            backtrack(nums, len, step + 1, used, path, res);
            used[i] = false;
            path.removeLast();
        }
    }
}
