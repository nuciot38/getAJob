package com.algorithm.WeekTwo;

/**
 * LeetCode 2020/5/17周赛
 */
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
//        int[][] points = {{-3, 0}, {3, 0}, {2, 6}, {5, 4}, {0, 9}, {7, 8}};
        int[][] points = {{1, 2}, {3, 5}, {1, -1}, {2, 3}, {4, 1}, {1, 3}};
        System.out.println(solution4.numPoints(points, 2));
    }

    double diff = 1e-8;

    public int numPoints(int[][] points, int r) {
        int res = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double disAB = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                if (disAB <= 2 * r) {
                    double a = Math.sqrt(r * r - 0.25 * disAB * disAB);
                    double midx = (points[i][0] + points[j][0]) / 2.0;
                    double midy = (points[i][1] + points[j][1]) / 2.0;
                    double vecABx = points[i][0] - points[j][0];
                    double vecABy = points[i][1] - points[j][1];
                    double basex = vecABy / disAB * a;
                    double basey = -vecABx / disAB * a;
                    double c1x = midx + basex;
                    double c1y = midy + basey;
                    double c2x = midx - basex;
                    double c2y = midy - basey;
                    res = Math.max(res, count(c1x, c1y, points, r));
                    if (c1x != c2x || c1y != c2y){
                        res = Math.max(res, count(c2x, c2y, points, r));
                    }
                }
            }
        }
        return res;
    }

    public int count(double c1x, double c1y, int[][] points, int r) {
        int res = 0;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            double a = c1x - x;
            double b = c1y - y;
            if (a * a + b * b <= r * r + diff) {
                res++;
            }
        }
        return res;
    }
}
