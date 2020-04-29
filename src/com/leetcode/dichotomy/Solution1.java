package com.leetcode.dichotomy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 102; i++) {
            list.add(i);
        }
        for (int i = 100; i > 0; i--) {
            list.add(i);
        }
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.findInMountainArray(81, list));
    }

    public int findInMountainArray(int target, List<Integer> mountainArr) {
        int len = mountainArr.size();
        int mid = findMontainTop(mountainArr, 0, len - 1);
        int in = getTargetIndexInc(mountainArr, target, 0, mid);
        if (in != -1){
            return in;
        }
        int des = getTargetIndexDec(mountainArr, target, mid + 1, len - 1);
        if (des != -1){
            return des;
        }
        return -1;

    }

    public int findMontainTop(List<Integer> mountainArr, int l, int r){
        while (l<r){
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }

    public int getTargetIndexInc(List<Integer> mountainArr, int target, int left, int right) {
        while (left < right){
            int mid = left + (right - left) / 2;
            if (target>mountainArr.get(mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if (mountainArr.get(left) == target){
            return left;
        }
        return -1;
    }

    public int getTargetIndexDec(List<Integer> mountainArr, int target, int left, int right) {
        while (left < right){
            int mid = left + (right - left) / 2;
            if (target > mountainArr.get(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if (target == mountainArr.get(left)){
            return left;
        }
        return -1;
    }

}
