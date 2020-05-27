package com.algorithm.offer.bitoperator;

public class Solution1 {
    /**
     * 考虑对一个整数做减法。
     * 如果这个整数的第m位是它从右边数的第一个1，即m的右边都是0，减1之后
     * m位变成0，右边都是1.如果此时对n和n-1做与操作，会让从m位开始都为0了。
     * 或者说，每做一次这样的操作，n都会去掉一个1，直到全变成0
     */
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = (n-1) & n;
        }
        return count;
    }
}
