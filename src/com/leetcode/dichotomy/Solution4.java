package com.leetcode.dichotomy;

public class Solution4 {
    public static void main(String[] args) {
        Solution4 so = new Solution4();
        int[] nums = {3, 1, 1};
        System.out.println(so.search(nums, 0));
    }
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end){
            mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[start] == nums[mid]){
                start++;
                continue;
            }
            if (nums[start] < nums[mid]){
                if (nums[mid] > target && nums[start] <= target){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else{
                if (nums[mid] < target && nums[end] >= target){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

}
