package com.david.day.d45;

/**
 * 2021-02-10
 */
public class NumIslands_200 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new Solution().numIslands(grid));
    }

    /**
     * dfs 上下左右走过的标记为0，走过一片数量+1
     */
    static class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {//为陆地才dfs搜索
                        dfsMark(i, j, grid);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfsMark(int i, int j, char[][] grid) {
            //terminator 下标越界或者不是陆地直接退出
            if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] != '1') return;
            //process 走过的置为0
            grid[i][j] = '0';
            //drill down 上下左右查找
            dfsMark(i + 1, j, grid);
            dfsMark(i - 1, j, grid);
            dfsMark(i, j + 1, grid);
            dfsMark(i, j - 1, grid);
            //revert states

        }
    }
}
