package com.david.algo.bsearch;

/**
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 思路
 * 1.O(n)遍历
 * 2.O(logn)二分法
 *
 * @author: david
 * @date: 2021/7/16
 */
public class Search_offer53 {
    public static void main(String[] args) {
//        System.out.println(new Search_offer53().new Solution().search(new int[]{5, 7, 7, 8, 8, 10}, 8));
//        System.out.println(new Search_offer53().new Solution1().search(new int[]{1}, 1));//1
//        System.out.println(new Search_offer53().new Solution1().search(new int[]{5, 7, 7, 8, 8, 10}, 6));//0
//        System.out.println(new Search_offer53().new Solution2().search(new int[]{5, 7, 7, 8, 8, 10}, 8));//2
//        System.out.println(new Search_offer53().new Solution3().search(new int[]{5, 7, 7, 8, 8, 10}, 8));//2
        System.out.println(new Search_offer53().new SolutionUpper().search(new int[]{5, 7, 7, 8, 8, 10}, 8));//4
        System.out.println(new Search_offer53().new SolutionLower().search(new int[]{5, 7, 7, 8, 8, 10}, 8));//3
    }

    /**
     * 二分上边界
     */
    class SolutionUpper {
        public int search(int[] nums, int t) {
            int n = nums.length, left = 0, right = n - 1;
            while (left < right) {
                int mid = left + right + 1 >> 1;
                if (nums[mid] <= t) left = mid;
                else right = mid - 1;
            }
            return right;
        }
    }

    /**
     * 二分下边界
     */
    class SolutionLower {
        public int search(int[] nums, int t) {
            int n = nums.length, left = 0, right = n - 1;
            while (left < right) {
                int mid = left + right >> 1;
                if (nums[mid] >= t) right = mid;
                else left = mid + 1;
            }
            return right;
        }
    }

    /**
     * O(n)遍历
     */
    class Solution {
        public int search(int[] nums, int target) {
            int res = 0;
            for (int num : nums) {
                if (num == target) res++;
            }
            return res;
        }
    }

    /**
     * 二分法 自己实现比较low
     * 1.先找到该元素
     * 2.左右展开相同元素
     */
    class Solution1 {
        public int search(int[] nums, int target) {
            int n = nums.length, left = 0, right = n - 1, i = -1, res = 0;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);//防止超过Integer上限
                if (nums[mid] == target) {
                    i = mid;
                    res++;
                    break;
                } else if (nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
            if (i == -1) return res;//一个都没找到
            //左右展开
            for (int j = i + 1; j < n && target == nums[j]; j++) res++;
            for (int j = i - 1; j >= 0 && target == nums[j]; j--) res++;
            return res;
        }
    }


    // 找到目标值「首次」出现的分割点，并「往后」进行统计
    class Solution2 {
        public int search(int[] nums, int t) {
            int n = nums.length, l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;//mid为会向下取整 偏向左边
                if (nums[mid] >= t) r = mid;//右边界向左逼近
                else l = mid + 1;
            }
            int ans = 0;
            while (l < n && nums[l] == t && l++ >= 0) ans++;
            return ans;
        }
    }

    // 找到目标值「最后」出现的分割点，并「往前」进行统计
    class Solution3 {
        public int search(int[] nums, int t) {
            int n = nums.length;
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;//mid向上取整
                if (nums[mid] <= t) l = mid;//左边界向右逼近
                else r = mid - 1;
            }
            int ans = 0;
            while (r >= 0 && nums[r] == t && r-- >= 0) ans++;
            return ans;
        }
    }

}
