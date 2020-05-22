package com.leetcode.presum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1371 每个元音包含偶数次的最长子字符串
 */
public class Solution1 {

    //前缀和+状态压缩
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= 1 << 0;
            } else if (ch == 'e') {
                status ^= 1 << 1;
            } else if (ch == 'i') {
                status ^= 1 << 2;
            } else if (ch == 'o') {
                status ^= 1 << 3;
            } else if (ch == 'u') {
                status ^= 1 << 4;
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    //暴力
    public int findTheLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] ch = s.toCharArray();
        int len = ch.length;
        Map<Character, Boolean> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (count > len - i) {
                break;
            }
            map.put('a', true);
            map.put('e', true);
            map.put('i', true);
            map.put('o', true);
            map.put('u', true);
            for (int j = i; j < len; j++) {
                if (map.containsKey(ch[j])) {
                    map.put(ch[j], !map.get(ch[j]));

                }
                if (ifsupport(map)) {
                    count = Math.max(count, j - i + 1);
                }
            }
        }
        return count;
    }

    public boolean ifsupport(Map<Character, Boolean> map) {
        for (Character c : map.keySet()) {
            if (!map.get(c)) {
                return false;
            }
        }
        return true;
    }
}
