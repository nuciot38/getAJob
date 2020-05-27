package com.algorithm.leetcode.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 90 子集II
 */
public class Solution9 {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        int[] num = {2, 1, 2};
        System.out.println(solution9.subsetsWithDup(num));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            backtrack(res, new ArrayList<>(), 0, nums, i);
        }
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> path, int curr, int[] nums, int len) {
        if (curr == len) {
            List<Integer> temp = new ArrayList<>(path);
            if (!res.contains(temp)) {
                res.add(temp);
            }
            return;
        }
        for (int i = curr; i < nums.length; i++) {
            path.add(nums[i]);
            curr++;
            backtrack(res, path, i + 1, nums, len);
            curr--;
            path.remove(new Integer(nums[i]));
        }
    }

}
