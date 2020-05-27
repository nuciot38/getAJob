package com.algorithm.leetcode.greed;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.intToRoman(1994));

    }

    public String intToRoman(int num){

        int nums[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < 13){
            while (num >= nums[index]){
                sb.append(roman[index]);
                num -= nums[index];
            }
            index++;
        }
        return sb.toString();
    }

}
