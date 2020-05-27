package com.algorithm.leetcode.pointer;

import java.util.Arrays;

/**
 * LeetCode 16 最接近的三数之和
 */
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution6 = new Solution4();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(solution6.threeSumClosest(nums, 1));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for(int i=0;i<len;i++){
            int start = i+1, end = len-1;
            while(start < end){
                int temp = nums[i] + nums[start] + nums[end];
                if(Math.abs(temp - target) < Math.abs(result - target)){
                    result = temp;
                }
                if(temp > target){
                    end--;
                }else if(temp < target){
                    start++;
                }else{
                    return result;
                }
            }
        }
        return result;
    }
}
