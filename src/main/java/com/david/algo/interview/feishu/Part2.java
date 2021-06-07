package com.david.algo.interview.feishu;

import java.util.ArrayList;
import java.util.List;

/**
 * 二面
 * input: 9,8,7,3,4,2,1
 * output: 9,8,7,2,1
 * <p>
 * input: 3,3,1
 * output: 1
 * <p>
 * 找到数组中, 比左边所有数字都小, 比右边所有数字都大的 数字
 */
public class Part2 {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 3, 4, 2, 1};
        System.out.println("result:");
//        new Part2().new Solution().find(arr);
        System.out.println(new Part2().new Solution().find(arr));
        System.out.println(new Part2().new Solution().find(new int[]{3, 3, 1}));
    }

    public class Solution {
        public List<Integer> find(int[] arr) {
            List<Integer> res = new ArrayList<>();
            int len = arr.length;
            int[] min = new int[len], max = new int[len];
            min[0] = Integer.MAX_VALUE;
            max[max.length - 1] = Integer.MIN_VALUE;
            for (int i = 1; i < len; i++) {
                min[i] = Math.min(min[i - 1], arr[i - 1]);//当前位置最小值
            }
            for (int i = len - 2; i >= 0; i--) {
                max[i] = Math.max(max[i + 1], arr[i + 1]);//当前位置最大值
            }
            for (int i = 0; i < len; i++) {
                if (arr[i] < min[i] && arr[i] > max[i]) res.add(arr[i]);
            }
            return res;
        }
    }
}
