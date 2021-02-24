package com.david.day.d34;

public class SearchMatrix_74 {
    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(new Solution().searchMatrix(m, 3));
    }

    /**
     * 使用二分查找
     * 有序就用二分查找！！！
     * 由于二维数组全局有序可以转化为类似一维数组解
     */
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length;
            if (row == 0) return false;
            int col = matrix[0].length;
            int left = 0, right = row * col - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int curr = matrix[mid / col][mid % col];
                if (curr == target) return true;
                if (curr > target) right = mid - 1;
                else left = mid + 1;
            }
            return false;
        }
    }

}
