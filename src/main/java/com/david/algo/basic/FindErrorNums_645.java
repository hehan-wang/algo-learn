package com.david.algo.basic;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 645. 错误的集合
 * 思路
 *
 * @author: david
 * @date: 2021/7/4
 */
public class FindErrorNums_645 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindErrorNums_645().new Solution1().findErrorNums(new int[]{1, 2, 2, 4})));//2,3
        System.out.println(Arrays.toString(new FindErrorNums_645().new Solution1().findErrorNums(new int[]{3, 2, 3, 4, 6, 5})));//3,1
    }

    /**
     * 使用异或一次遍历
     * 使用缓存先找到重复元素
     * 然后使用异或找到缺失元素
     * <p>
     * 利用异或特性：x^x=0
     * a:xor[1~4]=1^2^3^4
     * b:xor[1,2,2,4]=1^4
     * dup:2
     * b^2 -->1^2^4
     * b^2^a--> (1^2^4)^(1^2^3^4)=3
     * res[2,3]
     */
    class Solution1 {
        public int[] findErrorNums(int[] nums) {
            boolean[] seen = new boolean[nums.length + 1];
            int a = 0, b = 0, dup = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                a ^= (i + 1);
                b ^= num;
                if (seen[num]) dup = num;
                seen[num] = true;
            }
            return new int[]{dup, b ^ dup ^ a};
        }
    }

    /**
     * 使用一个额外空间存储nums
     * O(n)
     */
    class Solution {
        public int[] findErrorNums(int[] nums) {
            boolean[] seen = new boolean[nums.length + 1];
            int[] res = new int[2];
            for (int num : nums) {
                if (seen[num]) res[0] = num;//找到重复元素
                seen[num] = true;
            }
            for (int i = 1; i < seen.length; i++) {
                if (!seen[i]) {//找到缺失元素
                    res[1] = i;
                    break;
                }
            }
            return res;
        }
    }
}
