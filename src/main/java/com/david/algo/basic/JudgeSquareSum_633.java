package com.david.algo.basic;

/**
 *
 */
public class JudgeSquareSum_633 {
    /**
     * 双指针法a=最小值 b=最大值
     */
    class Solution {
        public boolean judgeSquareSum(int c) {
            int left = 0, right = (int) Math.sqrt(c);//右边界 b=sqrt(c-a^2), a>=0,所以b<sqrt(c)
            while (left <= right) {
                int tmp = left * left + right * right;
                if (tmp == c) return true;
                else if (tmp > c) right--;
                else left++;
            }
            return false;
        }
    }
}
