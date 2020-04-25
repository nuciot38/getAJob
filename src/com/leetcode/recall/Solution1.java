package com.leetcode.recall;

import java.util.*;

/**
 * LeetCode 46 全排列
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> list = solution1.permute(nums);
        System.out.println(list);
    }

    /**
     * 回溯算法
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, result);
        return result;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (depth == len) {
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < len; i++) {
            if (used[i] == false) {
                //在栈中添加一个未使用的元素
                path.addLast(nums[i]);
                //将添加到栈的元素的状态改成已使用
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, result);
                //回溯，将元素从栈中弹出，并将状态改为未使用
                path.removeLast();
                used[i] = false;
            }
        }
    }

    //不使用标记数组
    public List<List<Integer>> permute2(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        backtrack(len, output, result, 0);
        return result;
    }

    private void backtrack(int len, List<Integer> output, List<List<Integer>> result, int first) {
        if (first == len) {
            result.add(new ArrayList<>(output));
        }
        for (int i = first; i < len; i++) {
            //将使用过的元素放在左侧，未使用过的元素放在右侧
            Collections.swap(output, first, i);
            backtrack(len, output, result, first+1);
            Collections.swap(output, first, i);
        }

    }

}
