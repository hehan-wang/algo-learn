package com.david.algo.basic.stack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * 思路：
 * 求每个数最右大于当前数的间隔
 * 1.暴力法两次遍历 O(n^2)
 */
public class DailyTemperatures_739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperatures_739().new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(new DailyTemperatures_739().new Solution1().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    /**
     * 递减栈 栈内存递减元素。栈存下标
     * 当前元素比栈顶元素大的时候依次弹栈其他元素并填充结果，当前元素入栈。
     * O(n)因为每个元素只遍历一次
     */
    class Solution1 {
        public int[] dailyTemperatures(int[] T) {
            int n = T.length;
            int[] res = new int[n];
            LinkedList<Integer> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && T[i] > T[stack.peek()]) {//当前元素大于栈顶元素
                    Integer pre = stack.pop();
                    res[pre] = i - pre;
                }
                stack.push(i);
            }
            return res;
        }
    }

    /**
     * 暴力法
     * 两次遍历数组外层遍历每个元素。内层遍历当前元素后面的元素知道找到第一个比他大的数
     */
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int n = T.length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                int curr = T[i], other = i;
                for (int j = i; j < n; j++) {
                    if (T[j] > curr) {
                        other = j;
                        break;
                    }
                }
                res[i] = other - i;
            }
            return res;
        }
    }
}
