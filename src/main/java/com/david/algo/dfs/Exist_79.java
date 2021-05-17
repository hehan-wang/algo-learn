package com.david.algo.dfs;

/**
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class Exist_79 {
    public static void main(String[] args) {
//        System.out.println(new Exist_79().new Solution().exist(new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        }, "ABCCED"));
        System.out.println(new Exist_79().new Solution().exist(new char[][]{{'b'}, {'a'}, {'b'}, {'b'}, {'a'}}, "baa"));
    }

    /**
     * 思路：使用dfs上下左右搜
     * O(m*n*w) 跟数组board大小和word长度有关
     */
    class Solution {
        //保存方向
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        boolean res = false;

        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (res) return true;//提前返回
                    dfs(board, word, i, j, 0, word.length());
                }
            }
            return res;
        }

        private void dfs(char[][] board, String word, int i, int j, int w, int n) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '~') return;//到边界或者搜过了
            //存在w+1继续搜下一个字母 断了直接返回从头开搜
            if (word.charAt(w) == board[i][j]) w++;
            else return;

            if (w == n) {//到字符串末尾了
                res = true;
                return;
            }
            char origin = board[i][j];
            board[i][j] = '~';//搜过的打标记
            for (int d = 0; d < 4; d++) {
                dfs(board, word, i + dx[d], j + dy[d], w, n);
            }
            board[i][j] = origin;//回溯
        }
    }
}
