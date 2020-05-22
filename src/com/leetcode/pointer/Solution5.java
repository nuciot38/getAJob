package com.leetcode.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 18 四数之和
 */
public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution7 = new Solution5();
        int[] nums = {5,5,3,5,1,-5,1,-2};
        System.out.println(solution7.fourSum(nums, 4));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<len-3;i++){
            int min = nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(min > target){
                break;
            }
            int max = nums[i]+nums[len-1]+nums[len-2]+nums[len-3];
            if(max < target){
                continue;
            }
            for(int j=len-1;j>i+2;j--){
                int left = i+1, right = j-1;
                while(left<right){
                    int temp = nums[i]+nums[j]+nums[left]+nums[right];
                    if(temp == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        if (!res.contains(list)){
                            res.add(list);
                        }
                        left++;
                        right--;
                    }else if(temp < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
