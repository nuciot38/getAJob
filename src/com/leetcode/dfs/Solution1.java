package com.leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 200
 */

class Solution1 {
    public static void main(String[] args) {
        char[][] ch = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] ch2 = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(numIslands3(ch));
    }

    //深度优先遍历
    public static int numIslands(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int count = 0;
        for (int i = 0; i < nr; ++i) {
            for (int j = 0; j < nc; ++j) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        grid[r][c] = '0';
        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
            dfs(grid, r - 1, c);
        }
        if (r + 1 < nr && grid[r + 1][c] == '1') {
            dfs(grid, r + 1, c);
        }
        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
            dfs(grid, r, c - 1);
        }
        if (c + 1 < nc && grid[r][c + 1] == '1') {
            dfs(grid, r, c + 1);
        }
    }

    //广度优先遍历
    public static int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int count = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * nc + j);
                    while (!queue.isEmpty()) {
                        int id = queue.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row][col] == '1') {
                            grid[row - 1][col] = '0';
                            queue.add((row - 1) * nc + col);
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            grid[row + 1][col] = '0';
                            queue.add((row + 1) * nc + col);
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            grid[row][col - 1] = '0';
                            queue.add(row * nc + col - 1);
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            grid[row][col + 1] = '0';
                            queue.add(row * nc + col + 1);
                        }
                    }
                }
            }
        }
        return count;
    }

    //并查集
    public static int numIslands3(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int count = 0;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(i * nc + j, (i - 1) * nc + j);
                    }
                    if (i + 1 < nr && grid[i + 1][j] == '1') {
                        uf.union(i * nc + j, (i + 1) * nc + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(i * nc + j, i * nc + j - 1);
                    }
                    if (j + 1 < nc && grid[i][j + 1] == '1') {
                        uf.union(i * nc + j, i * nc + j + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }

    static class UnionFind {
        int count;
        int[] parent;
        int[] rank;


        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }
}