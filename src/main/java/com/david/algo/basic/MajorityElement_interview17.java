package com.david.algo.basic;

import java.util.HashMap;

/**
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 * @author: david
 * @date: 2021/7/9
 */
public class MajorityElement_interview17 {
    public static void main(String[] args) {
//        System.out.println(new MajorityElement_interview17().new Solution().majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));//5
//        System.out.println(new MajorityElement_interview17().new Solution().majorityElement(new int[]{2, 3}));//-1
//        System.out.println(new MajorityElement_interview17().new Solution().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));//2
        System.out.println(new MajorityElement_interview17().new Solution().majorityElement(new int[]{3, 3, 4}));//3
    }

    /**
     * 计数法
     * 使用map存元素数量 当遇到超过一半的元素return
     * O(n)
     */
    class Solution1 {
        public int majorityElement(int[] nums) {
            int targetCount = (nums.length >> 1) + 1;//超过一半
            HashMap<Integer, Integer> countMap = new HashMap<>();
            for (int num : nums) {
                int count = countMap.getOrDefault(num, 0) + 1;
                if (count >= targetCount) return num;
                countMap.put(num, count);
            }
            return -1;
        }
    }

    /**
     * 摩尔投票
     * <p>如果一个元素的数量超过一半，两个不同元素抵消，剩下的就是超过半数的
     */
    class Solution {
        public int majorityElement(int[] nums) {
            int x = -1, cnt = 0;//x存投票元素 cnt存x的个数
            for (int num : nums) {
                if (cnt == 0) {//cnt抵消完了换人
                    x = num;
                    cnt = 1;
                } else {
                    cnt += num == x ? 1 : -1;//相同累加+1 不同抵消-1
                }
            }
            cnt = 0;
            for (int num : nums) if (num == x) cnt++;//因为数据可能不存在'多数元素' 需要再次判断数量
            return cnt > (nums.length >> 1) ? x : -1;
        }
    }
}
