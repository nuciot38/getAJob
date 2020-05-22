package com.WeekTwo;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * LeetCode 2020/5/17 周赛
 * 1451 重新排列句子中的单词
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.arrangeWords("To be or not to be"));
    }

    public String arrangeWords(String text) {
        if (text.length() == 0) {
            return text;
        }
        String s = text.toLowerCase();
        String[] str = s.split(" ");
        if (str.length <= 1) {
            return text;
        }
        TreeMap<Integer, LinkedList<String>> map = new TreeMap<>();
        for (String word : str) {
            map.putIfAbsent(word.length(), new LinkedList<>());
            LinkedList<String> list = map.get(word.length());
            list.add(word);
        }
        int i = 0;
        for (Map.Entry<Integer, LinkedList<String>> entry : map.entrySet()) {
            LinkedList<String> value = entry.getValue();
            for (String word : value) {
                str[i] = word;
                i++;
            }
        }
        str[0] = str[0].substring(0, 1).toUpperCase() + (str[0].length() > 1 ? str[0].substring(1) : "");
        return String.join(" ", str);
    }
}
