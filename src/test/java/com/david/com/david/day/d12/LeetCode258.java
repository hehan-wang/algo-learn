package com.david.com.david.day.d12;

/**
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 */
public class LeetCode258 {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits1(38));
        System.out.println(addDigits2(38));
    }

    //循环解法
    public static int addDigits2(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                int i = num % 10;
                sum += i;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }


    //递归解法
    public static int addDigits1(int num) {
        if (num < 10) return num;
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return addDigits(sum);
    }


    /**
     * O(1)的解法
     * https://leetcode-cn.com/problems/add-digits/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-7/
     * 数字根
     * 遇到问题可以枚举找规律！！！
     * 原数: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
     * 数根: 1 2 3 4 5 6 7 8 9  1  2  3  4  5  6  7  8  9  1  2  3  4  5  6  7  8  9  1  2  3
     */
    public static int addDigits(int num) {
        return (num < 10) ? num : num % 9 == 0 ? 9 : num % 9;
    }
}
