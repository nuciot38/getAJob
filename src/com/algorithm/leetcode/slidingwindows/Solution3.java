package com.algorithm.leetcode.slidingwindows;

/**
 * LeetCode 424 替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，
 * 你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
 * 在执行上述操作后，找到包含重复字母的最长子串的长度。
 */
public class Solution3 {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    /**
     * 只考虑大写字母，可以定义一个整型数组，用于存放每个字母的个数
     * 1.窗口的left和right初始为0,，开始循环后，right++
     * 2.通过字节相减获取当前字母是第几个，从而对数组中当前元素++，表示当前窗口中该字母的个数
     * 3.求出当前窗口中最多元素的个数
     * 4.比较当前窗口大小是否大于当前窗口所能包含的最多相同字母数
     * 5.如果大于，则将left的字母从窗口中移除出去，并且left++，此时窗口的大小同上一步循环大小相等
     */

    private static int[] map = new int[26];
    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] ch = s.toCharArray();
        int max = 0;
        int left = 0;
        int right = 0;
        for (right = 0; right < ch.length; right++) {
            int index = ch[right] - 'A';
            map[index]++;
            max = Math.max(max, map[index]);
            if (right - left + 1 > max + k) {
                map[ch[left] - 'A']--;
                left++;
            }
        }
        return right - left;
    }
}
