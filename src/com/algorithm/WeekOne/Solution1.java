package com.algorithm.WeekOne;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020/5/10 LeetCode周赛
 * 5404用栈操作构建数组
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] target = {1, 3};
        Solution1 solutionWeek = new Solution1();
        System.out.println(solutionWeek.buildArray(target, 3));
    }
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int len = target.length;
        int index = 0;
        for (int i=1;i<=target[len-1];i++){
            if (i == target[index]){
                res.add("Push");
                index++;
            }else {
                res.add("Push");
                res.add("Pop");
            }
            if (i == n){
                break;
            }
        }
        return res;
    }
}
