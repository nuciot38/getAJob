package com.leetcode.string;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 9 Z字型变换
 */
public class Solution1 {

    public static void main(String[] args) {
        String str = "LEETCODEISHIRING";
        int numRows = 3;
        System.out.println(convert(str, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows<2){
            return s;
        }
        List<StringBuilder> list = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        char[] ch = s.toCharArray();
        int i=0, flag = -1;
        for (char c:ch){
            list.get(i).append(c);
            if (i == 0 || i == numRows-1){
                flag = -flag;
            }
            i += flag;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            sb.append(list.get(j));
        }
        return sb.toString();
    }
}
