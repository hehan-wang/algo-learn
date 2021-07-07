package com.david.algo.basic;

import java.util.HashMap;

/**
 * @author: david
 * @date: 2021/7/7
 * 思路：
 * 1.两次循环枚举两个元素 判断相加是不是2^n
 */
public class CountPairs_1711 {
    public static void main(String[] args) {
        System.out.println(new CountPairs_1711().new Solution().countPairs(new int[]{1, 3, 5, 7, 9}));
    }

    /**
     * 使用hash表存计数
     * O(nlogn)
     */
    class Solution {
        public int countPairs(int[] deliciousness) {
            int mod = 1000000007, res = 0, maxVal = 0;
            for (int i : deliciousness) maxVal = Math.max(maxVal, i);
            int maxSum = maxVal << 1;//最大值超不过数组最大值的两倍
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < deliciousness.length; i++) {
                int food = deliciousness[i];
                for (int j = 1; j <= maxSum; j <<= 1) {//每次除2去哈希表找
                    if (map.containsKey(j - deliciousness[i])) res = (res + map.get(j - deliciousness[i])) % mod;
                }
                map.put(food, map.getOrDefault(food, 0) + 1);//计数+1
            }
            return res;
        }
    }
}
