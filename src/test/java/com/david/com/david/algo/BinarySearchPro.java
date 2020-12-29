package com.david.com.david.algo;

/**
 * 二分查找变种
 * 存在重复元素的数据找第一个匹配到的数字
 */
public class BinarySearchPro {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 8, 8, 8, 22, 45, 13234, 134241};
        System.out.println("index:" + bSearch(a, 8));
        System.out.println("index:" + bSearch1(a, 8));
    }

    /**
     * 争哥简单理解版
     */
    public static int bSearch1(int[] a, int value) {
        int high = a.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) high = mid - 1;
            else if (a[mid] > value) low = mid + 1;
            else {
                //存在相等 mid为0 或 a[mid-1]和a[mid]不相等 证明前面没有
                if (mid == 0 || a[mid - 1] != a[mid]) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 难理解版
     * high不断向前挤压
     */
    public static int bSearch(int[] a, int value) {
        int n = a.length;
        int high = n - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        //如果存在等值返回low
        if (low < n && a[low] == value) {
            return low;
        } else {
            return -1;
        }
    }
}
