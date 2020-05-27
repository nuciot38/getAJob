package com.algorithm.offer.recursion;

/**
 * 剑指offer 10- I. 斐波那契数列
 * 斐波那契数列F(n) = F(n-1) + F(n-2)
 * 菲波那契数列的三种思路
 * 1.递归，缺点在于存在多次重复计算层数低的数据
 * 2.记忆化递归，缺点在于虽然记忆了每一层递归的数，但是造成了开辟了长度为n的的数组
 * 3.动态规划，只保留F(n-1)和F(n-2)用于计算
 */

public class Solution1 {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        int first = 0;
        int second = 1;
        int result = 0;
        for(int i=2;i<=n;i++){
            result = (first + second)% 1000000007;
            first = second;
            second = result;
        }
        return result;
    }
}
