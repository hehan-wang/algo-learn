package com.david.algo.bit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 477. 汉明距离总和
 * 输入: 4, 14, 2
 * <p>
 * 输出: 6
 * <p>
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 */
public class TotalHammingDistance_477 {
    public static void main(String[] args) {
        System.out.println(new TotalHammingDistance_477().new Solution().totalHammingDistance(new int[]{4, 14, 2}));
        System.out.println(new TotalHammingDistance_477().new Solution1().totalHammingDistance(new int[]{4, 14, 2}));
    }

    /**
     * 暴力两次遍历
     */
    class Solution1 {

        public int totalHammingDistance(int[] nums) {
            int res = 0, n = nums.length;
            for (int i = 0; i < n - 1; i++) {//留出下一个的位置
                for (int j = i + 1; j < n; j++) {
                    res += Integer.bitCount(nums[i] ^ nums[j]);
                }
            }
            return res;
        }
    }

    /**
     * 排列+汉明距离
     */
    class Solution {
        List<Integer> path = new ArrayList<>();
        int ans = 0;
        public int totalHammingDistance(int[] nums) {
            backTrack(nums, 0);
            return ans;
        }

        public void backTrack(int[] nums, int start_index){
            if(path.size() == 2){
                ans += hammingDistance(path.get(0), path.get(1));
                return;
            }
            for(int i = start_index; i<nums.length; i++){
                path.add(nums[i]);
                backTrack(nums, i+1);
                path.remove(path.size()-1);
            }
        }

        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }
}
