package com.david.algo.basic;

/**
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * <p>
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * <p>
 * 所以，4 是第一个错误的版本。 
 */
public class FirstBadVersion_278 {
    /**
     * 二分法 O(logn)
     */
    public class Solution1 extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1, right = n;
            while (left < right) {
                int mid = (left + ((right - left) >> 1));
                if (isBadVersion(mid))  right = mid;
                else left = mid + 1;
            }
            return right;
        }
    }


    /**
     * 从后向前遍历
     * O(n)
     */
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            for (int i = n; i > 0; i--) {
                if (!isBadVersion(i)) return i + 1;
            }
            return 1;
        }
    }


    private class VersionControl {
        boolean isBadVersion(int version) {
            return false;
        }
    }
}
