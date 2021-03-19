package com.david.day.d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * 思路
 * 1.X 暴力法 转成数字 +1 转成数组 。long也会超长
 * 2.从尾部依次+1 ,>=10 进位
 */
public class PlusOne_66 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new PlusOne_66().new Solution().plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new PlusOne_66().new Solution().plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println(Arrays.toString(new PlusOne_66().new Solution().plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(new PlusOne_66().new Solution().plusOne(new int[]{1, 9})));
    }

    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i] = (digits[i] + 1) % 10;//每一位+1 取模
                if (digits[i] > 0) return digits; //没进位结束
            }
            int[] res = new int[digits.length + 1];//进位 99+1
            res[0] = 1;
            return res;
        }
    }
}
