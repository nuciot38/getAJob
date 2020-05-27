package com.algorithm.leetcode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 78 子集
 */
public class Solution10 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length+1;i++){
            backtrack(0, res, new ArrayList<Integer>(), nums, i);
        }
        return res;
    }
    public void backtrack(int index, List<List<Integer>> res, ArrayList<Integer> path, int[] nums, int k){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            backtrack(i+1, res, path, nums, k);
            path.remove(path.size()-1);
        }
    }
}
