package com.algorithm.leetcode.recall;


import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 89 格雷编码
 */

public class Solution8 {
    public static void main(String[] args) {
        int n = 2;
        Solution8 solution8 = new Solution8();
//        System.out.println(solution8.grayCode(n));
        System.out.println(3<<1);
    }
    public List<Integer> grayCode(int n) {
        int sum = n * n;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<sum;i++){
            list.add(i);
        }
        List<Integer> res = new ArrayList<>();
        res.add(0);
        backTrack(list, res, 0, sum);
        return res;
    }

    public void backTrack(List<Integer> list, List<Integer> res, int cur, int sum){
        while(res.size() == sum){
            return;
        }
        for(int i=0;i<list.size();i++){
            int temp = list.get(i);
            if (cur == 0 && temp == 1){
                res.add(temp);
            }
            if((temp ^ cur) % 2 == 0){
                list.remove(i);
                res.add(temp);
                backTrack(list, res, temp, sum);
                list.add(temp);
            }
        }
    }
}
