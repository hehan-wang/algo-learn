package com.david.algo.basic;

/**
 * 输入：arr = [0,2,1,0]
 * 输出：1
 */
public class PeakIndexInMountainArray_852 {
    public static void main(String[] args) {
        System.out.println(new PeakIndexInMountainArray_852().new Solution().peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(new PeakIndexInMountainArray_852().new Solution1().peakIndexInMountainArray(new int[]{0, 1, 0}));
        ;
    }

    /**
     * 二分法
     * O(logn
     *
     * )
     */
    class Solution1 {
        public int peakIndexInMountainArray(int[] arr) {
            int n = arr.length;
            if (n < 3) return -1;
            for (int l = 1, r = n - 2; l <= r; ) {
                int mid = l + (r - l) / 2;
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
                if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) r = mid - 1;//单调递减 证明山峰在左边
                else l = mid + 1;//否则山峰在右边
            }
            return -1;
        }
    }

    /**
     * O(n)
     */
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int n = arr.length;
            if (n < 3) return -1;
            for (int i = 1; i < n - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) return i;
            }
            return -1;
        }
    }
}
