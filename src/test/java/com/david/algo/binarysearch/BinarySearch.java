package com.david.algo.binarysearch;

/**
 * 二分查找
 * 不存在重复元素查找给出数字的下标
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 3, 6, 22, 45, 13234, 134241};
        System.out.println("index:" + bSearch(a, 22));
        System.out.println("index:" + bSearch1(a, 22));
        System.out.println("index:" + bSearch2(a, 22));
    }

    //第一版
    public static int bSearch(int[] a, int value) {
        int low = 0;
        int high = a.length;
        while (low <= high) {//有可能存在只有一个元素所以得<=
            int mid = (low + high) / 2;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //第二版
    public static int bSearch1(int[] a, int value) {
        int low = 0;
        int high = a.length;
        while (low <= high) {
            //1. 使用位移增加运算速度
            //2. 使用ow + (high - low) >> 1 代替(high + low) 防止Integer最大溢出
            int mid = low + (high - low) >> 1;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //使用递归
    public static int bSearch2(int[] a, int value) {
        return bSearch3Internal(a, 0, a.length, value);
    }

    public static int bSearch3Internal(int[] a, int low, int high, int value) {
        if (low > high) {//low>high 证明遍历结束没有找到
            return -1;
        }
        int mid = low + (high - low) >> 1;
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] > value) {
            return bSearch3Internal(a, low, mid - 1, value);
        } else {
            return bSearch3Internal(a, mid + 1, high, value);
        }
    }
}
