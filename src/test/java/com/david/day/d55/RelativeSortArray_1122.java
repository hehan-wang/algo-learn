package com.david.day.d55;


import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 思路
 * 1.自定义排序 存在arr2 map中的按index 从小到大排序
 * 2.
 * 先计数arr1 放入map中
 * 在遍历arr2 map中存在则减少一个
 * 最后遍历剩余map
 */
public class RelativeSortArray_1122 {

    public static void main(String[] args) {
        int[] res = new Solution().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        System.out.println(Arrays.toString(res));
    }

    static class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] res = new int[arr1.length];
            int index = 0;
            //1.按顺序缓存到数组
            int[] counts = new int[1001];
            for (int j : arr1) {
                counts[j]++;
            }
            //2.遍历在arr2中的元素
            for (int num : arr2) {
                while (counts[num]-- > 0) {
                    res[index++] = num;
                }
            }
            //3.遍历count剩余大于0的
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0) {
                    while (counts[i]-- > 0) {
                        res[index++] = i;
                    }
                }
            }
            return res;
        }
    }
}
