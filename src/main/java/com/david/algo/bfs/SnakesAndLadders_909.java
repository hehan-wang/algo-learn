package com.david.algo.bfs;

import java.util.*;

/**
 * 909. 蛇梯棋
 * <p>
 * 输入：[
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,35,-1,-1,13,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,15,-1,-1,-1,-1]]
 * 输出：4
 * 解释：
 * 首先，从方格 1 [第 5 行，第 0 列] 开始。
 * 你决定移动到方格 2，并必须爬过梯子移动到到方格 15。
 * 然后你决定移动到方格 17 [第 3 行，第 5 列]，必须爬过蛇到方格 13。
 * 然后你决定移动到方格 14，且必须通过梯子移动到方格 35。
 * 然后你决定移动到方格 36, 游戏结束。
 * 可以证明你需要至少 4 次移动才能到达第 N*N 个方格，所以答案是 4。
 */
public class SnakesAndLadders_909 {
    public static void main(String[] args) {
        int[][] matrix = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        matrix = new int[][]{{-1, -1, 19, 10, -1}, {2, -1, -1, 6, -1}, {-1, 17, -1, 19, -1}, {25, -1, 20, -1, -1}, {-1, -1, -1, -1, 15}};

        System.out.println(new SnakesAndLadders_909().new Solution().snakesAndLadders(matrix));
        System.out.println(new SnakesAndLadders_909().new Solution1().snakesAndLadders(matrix));
    }

    class Solution1 {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            int[] nums = twoForOne(board, n);
            System.err.println(Arrays.toString(nums));
            //存储已经遍历过的位置
            HashSet<Integer> set = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            int ans = 0;
            queue.offer(1);
            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    int cur = queue.poll();
                    if (cur == n * n) {
                        return ans;
                    }
                    if (!set.contains(cur)) {
                        //System.out.println("第"+ans+"步到了"+cur);
                        BFS(queue, cur, nums);
                        set.add(cur);
                    }
                }
                ans++;
            }
            return -1;
        }

        public int[] twoForOne(int[][] board, int n) {
            int[] nums = new int[n * n + 1];
            int index = 0;
            for (int i = n - 1; i >= 0; i--) {
                //取最下方为第一行,奇数行正向,偶数行反向
                int row = n - i;
                if (row % 2 == 1) {
                    for (int j = 0; j < n; j++) {
                        nums[++index] = board[i][j];
                    }
                } else {
                    for (int j = n - 1; j >= 0; j--) {
                        nums[++index] = board[i][j];
                    }
                }
            }
            // for (int num : nums) System.out.print(num+ " ");
            return nums;
        }

        public void BFS(Queue<Integer> queue, int cur, int[] nums) {
            int N = 6;
            //一次移动 1-6 ,不能走出棋盘
            for (int i = 1; i <= N && (cur + i) < nums.length; i++) {
                //如果走到需要传送的位置,则TP(传送)
                if (nums[cur + i] != -1) {
                    queue.offer(nums[cur + i]);
                } else {
                    queue.offer(cur + i);
                }
            }
        }

    }

    /**
     * 思路
     * 1.展开成一维数组
     * 2.bfs
     */
    class Solution {
        public int snakesAndLadders(int[][] board) {
            //转化成一维数组
            int n = board.length, total = n * n, count = 0;
            int[] b = new int[total + 1];
            for (int i = n - 1, index = 1; i >= 0; i--) {//从左下角开始 奇数正行 偶数反
                boolean naturalOrder = ((n - i) & 1) == 1;
                if (naturalOrder) {
                    for (int j = 0; j < n; j++) b[index++] = board[i][j];
                } else {
                    for (int j = n - 1; j >= 0; j--) b[index++] = board[i][j];
                }
            }
            System.err.println(Arrays.toString(b));

            //bfs
            Queue<Integer> quque = new LinkedList<>();
            Set<Integer> seen = new HashSet<>();
            quque.offer(1);//root放入第一层
            while (!quque.isEmpty()) {
                int size = quque.size();
                while (size-- > 0) {
                    Integer curr = quque.poll();
                    if (curr == total) return count;//搜完了
                    if (seen.contains(curr)) continue;
                    seen.add(curr);
                    for (int i = 1; i <= 6; i++) {//六个方向bfs
                        int next = curr + i;
                        if (next > total) break;
                        if (b[next] != -1) next = b[next];//存在梯子传送
                        quque.offer(next);
                    }
                }
                count++;
            }
            return -1;
        }
    }
}
