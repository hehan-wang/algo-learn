package com.david.algo.greedy;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 */
public class FindContentChildren_455 {
    public static void main(String[] args) {
        System.out.println(new FindContentChildren_455().new Solution().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    }

    /**
     * 贪心让每次分配满足的最小的饼干
     * O(nlogn+mlogm)
     */
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            //先排序方便从小到大分配
            Arrays.sort(g);
            Arrays.sort(s);
            int count = 0, children = g.length, cookies = s.length;
            for (int child = 0, cookie = 0; child < children && cookie < cookies; ) {
                if (s[cookie] >= g[child]) {//分配到了 数量+1 小朋友和饼干各+1
                    count++;
                    cookie++;
                    child++;
                } else {//饼干不够大 继续向后找大的饼干
                    cookie++;
                }
            }
            return count;
        }
    }
}
