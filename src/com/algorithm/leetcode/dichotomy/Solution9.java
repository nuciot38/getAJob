package com.algorithm.leetcode.dichotomy;

import java.util.Comparator;

/**
 * LeetCode 34 在排序数组中查找元素的第一个和最后一个元素
 */
public class Solution9 {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(solution9.searchRange(nums, target));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length;
        int[] res = {-1, -1};
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                int l = mid-1, r = mid+1;
                while(l >=0){
                    if(nums[l] == target){
                        l--;
                    }else{
                        break;
                    }
                }
                res[0] = l;
                while(r <nums.length){
                    if(nums[r] == target){
                        r++;
                    }else {
                        break;
                    }
                }
                res[1] = r;
                break;
            }else if(nums[mid] > target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return res;
    }

}
