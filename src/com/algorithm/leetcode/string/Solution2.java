package com.algorithm.leetcode.string;


public class Solution2 {

    public static void main(String[] args) {
        System.out.println(myAtoi("  -42"));
    }

    public static int myAtoi(String str) {
        int result = 0;
        int i = 0;
        int flag = 1;
        char[] ch = str.toCharArray();
        while (i < ch.length && ch[i] == ' ') {
            i++;
        }

        if (i == ch.length) {
            return 0;
        }
        if (ch[i] == '-') {
            flag = -1;
            i++;
        } else if (ch[i] == '+') {
            i++;
        } else if (!Character.isDigit(ch[i])) {
            return 0;
        }
        while (i < ch.length && Character.isDigit(ch[i])) {
            int num = ch[i] - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && num > 7)) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + num;
            i++;
        }
        return flag > 0 ? result : -result;
    }
}
