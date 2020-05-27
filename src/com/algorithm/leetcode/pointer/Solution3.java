package com.algorithm.leetcode.pointer;


/**
 * LeetCode 680 验证回文字符串II
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution2 = new Solution3();
        System.out.println(solution2.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
    public boolean validPalindrome(String s) {
        char[] sch = s.toCharArray();
        int left = 0, right = sch.length-1;
        while(left < right){
            if(sch[left] == sch[right]){
                left++;
                right--;
            }else {
                boolean flagl = true;
                boolean flagr = true;
                for (int i=left+1, j=right;i<j;i++, j--){
                    if (sch[i] != sch[j]){
                        flagl = false;
                        break;
                    }
                }
                for (int i=left, j=right-1;i<j;i++, j--){
                    if (sch[i] != sch[j]){
                        flagr = false;
                        break;
                    }
                }
                return flagl || flagr;
            }
        }
        return true;
    }
}
