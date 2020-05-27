package com.algorithm.WeekTwo;

/**
 * LeetCode 2020/5/17周赛
 * 1450在既定时间做作业的学生人数
 */
public class Solution1 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        int len = startTime.length;
        for (int i=0;i<len;i++){
            if (queryTime > startTime[i] && queryTime < endTime[i]){
                count++;
            }
        }
        return count;
    }
}
