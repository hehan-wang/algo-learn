package com.david.algo.dfs;

/**
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 * <p>
 * 输入：jobs = [1,2,4,7,8], k = 2
 * 输出：11
 * 解释：按下述方式分配工作：
 * 1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
 * 2 号工人：4、7（工作时间 = 4 + 7 = 11）
 * 最大工作时间是 11 。
 */
public class MinimumTimeRequired_1723 {
    public static void main(String[] args) {
        System.out.println(new MinimumTimeRequired_1723().new Solution().minimumTimeRequired(new int[]{3, 2, 3}, 3));//12次
        System.out.println(new MinimumTimeRequired_1723().new Solution1().minimumTimeRequired(new int[]{3, 2, 3}, 3));//12次
//        System.out.println(new MinimumTimeRequired_1723().new Solution().minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));//50次
//        System.out.println(new MinimumTimeRequired_1723().new Solution().minimumTimeRequired(new int[]{254, 256, 256, 254, 251, 256, 254, 253, 255, 251, 251, 255}, 10));
    }

    /**
     * 优化 增加used 尽量每次分配给空闲工人减少浪费
     */
    class Solution1 {
        int ans = Integer.MAX_VALUE, n = 0, k = 0;
        int[] jobs, sum;

        public int minimumTimeRequired(int[] jobs, int k) {
            this.k = k;
            this.jobs = jobs;
            this.n = jobs.length;
            this.sum = new int[k];//工作负载情况
            dfs(0, 0, 0);
            return ans;
        }

        /**
         * @param u    当前分配到哪个任务
         * @param used 当前分配到哪个人了
         * @param max  当前分配状态的最大工作时间
         */
        public void dfs(int u, int used, int max) {
            if (max >= ans) return; //计算最小的'最大工作量' 每次都取比上次小一点的
            if (u == n) {//这时候的max为任务分配结束时候的最大工作时间
                ans = max;
                return;
            }
            if (used < k) {// n=3 k=3的情况dfs三次就解决问题了 走不到下面的循环了 相当于每个人先领一个任务
                sum[used] = jobs[u];
                dfs(u + 1, used + 1, Math.max(sum[used], max));//优先分配给下一个工人 剪枝
                sum[used] = 0;
            }
            for (int i = 0; i < used; i++) {//给used个人分配任务
                sum[i] += jobs[u];
                dfs(u + 1, used, Math.max(sum[i], max));
                sum[i] -= jobs[u];
            }
        }
    }

    /**
     * dfs 把所有工作 分配给人全都遍历一遍
     * O(k^n)
     */
    class Solution {
        int res = Integer.MAX_VALUE, n = 0, k = 0;
        int[] jobs, workload;

        public int minimumTimeRequired(int[] jobs, int k) {
            this.k = k;
            this.jobs = jobs;
            this.n = jobs.length;
            this.workload = new int[k];//工作负载情况
            dfs(0, 0);
            return res;
        }

        /**
         * @param job 当前分配到哪个任务
         * @param max 当前分配状态的最大工作时间
         */
        public void dfs(int job, int max) {
            if (max >= res) return; //计算最小的'最大工作量' 每次都取比上次小一点的
            if (job == n) {//这时候的max为任务分配结束时候的最大工作时间
                res = max;
                return;
            }
            for (int i = 0; i < k; i++) {//给k个人分配任务
                workload[i] += jobs[job];
                dfs(job + 1, Math.max(workload[i], max));
                workload[i] -= jobs[job];
            }
        }
    }
}
