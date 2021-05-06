package com.david.algo.d2021_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * <p>
 * sum = curr + other * (numCount.get(other) - (other == curr ? 1 : 0));
 */
public class DeleteAndEarn_740 {
    public static void main(String[] args) {
        int i = new DeleteAndEarn_740().new Solution().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4});
        System.out.println(i);
    }

    /**
     * 先把数组排序计算每个数字出现的次数
     * 由于拿了当前数字，前面就不能拿了跟打家劫舍类似
     * dp[i][0] 存没取最后一个数的最大值
     * dp[i][1] 存取了最后一个数的最大值
     * <p>
     * dp[i][0]=max(dp[i-1][1],dp[i-1][0])
     * dp[i][1]=dp[i-1][0]+i*cnt[i]
     */
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int[] counts = new int[10009];//由于数字范围 1~10^4 存储数字出现的次数
            int maxNum = 0;//存最大数字
            for (int num : nums) {
                counts[num]++;
                maxNum = Math.max(num, maxNum);
            }
            int[][] dp = new int[maxNum + 1][2];
            for (int i = 1; i <= maxNum; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = dp[i - 1][0] + i * counts[i];
            }
            return Math.max(dp[maxNum][0], dp[maxNum][1]);
        }
    }
}
