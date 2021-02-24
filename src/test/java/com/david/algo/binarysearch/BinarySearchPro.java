package com.david.algo.binarysearch;

/**
 * 有序就可以使用二分查找
 * 二分查找变种
 * 存在重复元素的数据找第一个匹配到的数字
 */
public class BinarySearchPro {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 8, 8, 8, 22, 45, 13234, 134241};
        System.out.println("difficult index:" + bSearchFirstDifficult(a, 8));
        System.out.println("first eq index:" + bSearchFirst(a, 8));
        System.out.println("last eq index:" + bSearchLast(a, 8));
        System.out.println("first ge index:" + bSearchFirstGE(a, 8));
        System.out.println("first ge index:" + bSearchFirstGE(a, 6));
        System.out.println("first ge index:" + bSearchFirstGE(a, 9));
        System.out.println("last le index:" + bSearchLastLE(a, 8));
        System.out.println("last le index:" + bSearchLastLE(a, 20));
        System.out.println("last le index:" + bSearchLastLE(a, 22));
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * 后一个大于value 当前小于等于value
     */
    public static int bSearchLastLE(int[] a, int value) {
        int high = a.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {
                if (mid == a.length - 1 || a[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于value
     */
    public static int bSearchFirstGE(int[] a, int value) {
        int high = a.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (low == 0 || a[mid - 1] < value) {//前一个小于value 当前值大于等于value mid就是第一个大于等于value的下标
                    return mid;
                } else {
                    high = mid + 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个
     */
    public static int bSearchLast(int[] a, int value) {
        int high = a.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) high = mid - 1;
            else if (a[mid] < value) low = mid + 1;
            else {
                if (mid == a.length - 1 || a[mid] != a[mid + 1]) return mid;//存在等值。当前为最后一个或者后一个跟当前不等匹配成功
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 争哥简单理解版
     */
    public static int bSearchFirst(int[] a, int value) {
        int high = a.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) high = mid - 1;
            else if (a[mid] < value) low = mid + 1;
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
    public static int bSearchFirstDifficult(int[] a, int value) {
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
