package com.algorithm.offer;

    /**
     * 题目：
     * 在一个二维数组中（每个一维数组的长度相同）
     * 每一行都按照从左到右递增的顺序排序
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
     */


    /**
     * 解题思路：
     * 两层循环
     * 如果是从左上或者右下开始，i++,j++会漏掉当前元素下方和右方可能正确的元素
     * 所以从右上或者左下方开始，旁边的两个数一个比当前数字大，另一个比当前数字小
     * 下一轮比较的数字肯定比当前的数字相邻的两个数字都要大或者小
     */
public class Three {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target = 10;
        System.out.println(solution(arr, target));
    }
    public static boolean solution(int[][] arr, int target){
        int len = arr[0].length;
        for (int i=0;i<arr.length;i++){
            for (int j=len-1;j>0;j--){
                if (arr[i][j] == target){
                    return true;
                }
            }
        }


        return false;
    }
}
