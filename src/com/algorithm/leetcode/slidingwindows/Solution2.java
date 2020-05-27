package com.algorithm.leetcode.slidingwindows;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 3 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入abcabcbb， 输出3
 */


public class Solution2 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 1.定义临时数组和最大数组
     * 2.当临时数组包含当前字符时，比较临时数组的大小是否大于最大数组
     * 3.如果大于，则将当前临时数组赋值给最大值数组
     * 4.获取当前比较数组在临时数组中的下标，将下标及以前的元素remove出去
     * 5.完成上述操作后，将当前元素add到临时数组中
     * 6.比较临时数组和最大数组，返回最大值
     */

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] ch = s.toCharArray();
        List<String> tempList = new ArrayList<>();
        List<String> maxList = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            String str = new String(new char[ch[i]]);
            if (tempList.contains(str)) {
                if (tempList.size() > maxList.size()) {
                    maxList = new ArrayList<>(tempList);
                }
                int index = tempList.indexOf(str);
                for (int j = 0; j <= index; j++) {
                    tempList.remove(0);
                }
            }
            tempList.add(str);
        }
        return Math.max(tempList.size(), maxList.size());
    }
}
