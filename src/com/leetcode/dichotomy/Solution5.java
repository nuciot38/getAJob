package com.leetcode.dichotomy;

/**
 * LeetCode 74 搜索二维矩阵
 */
public class Solution5 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int index = 0;
//        for (index = 0; index <= m; index++) {
//            if (matrix[index][n] >= target) {
//                break;
//            }
//        }
        while(index<m && matrix[index][n] < target){
            index++;
        }
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[index][mid] == target){
                return true;
            }else if (matrix[index][mid] < target){
                left = mid + 1;
            }else {
                right = mid + 1;
            }
        }
        return false;
    }
}
