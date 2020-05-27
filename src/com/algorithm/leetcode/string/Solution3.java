package com.algorithm.leetcode.string;

/**
 *  LeetCode 38 外观数列
 */
public class Solution3 {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        int p1 = 0;
        int cur = 1;
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        for (cur = 1;cur < str.length();cur++){
            if (str.charAt(p1) != str.charAt(cur)){
                int count = cur - p1;
                sb.append(count).append(str.charAt(p1));
                p1 = cur;
            }
        }
        if (p1 != cur){
            int count = cur - p1;
            sb.append(count).append(str.charAt(p1));
        }
        return sb.toString();
    }
}
