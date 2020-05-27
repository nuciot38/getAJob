package com.algorithm.leetcode.array;

/**
 * LeetCode 59 螺旋矩阵II
 */
public class Solution4 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1, all = n * n;
        int l = 0, i = 0, r = n-1, j = n - 1;
        while(num <= all){
            for(int start=l;start<=r;start++){
                res[i][start] = num++;
            }
            i++;
            for(int start = i;start<=j;start++){
                res[start][r] = num++;
            }
            r--;
            for(int start = r;start >= l;start--){
                res[j][start] = num++;
            }
            j--;
            for(int start = j;start>=i;start--){
                res[start][l] = num++;
            }
            l++;
        }
        return res;

    }
}
