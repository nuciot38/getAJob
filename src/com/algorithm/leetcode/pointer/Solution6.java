package com.algorithm.leetcode.pointer;

/**
 * LeetCode 80 删除数组中的重复项II
 */
public class Solution6 {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int flag = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                flag++;
                if(flag <= 2){
                    nums[index++]=nums[i];
                }
            }else{
                nums[index++]=nums[i];
                flag = 1;
            }
        }
        return index;
    }
}
