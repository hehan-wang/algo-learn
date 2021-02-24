package com.david.day.d43;

public class SearchMatrix_74 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(new Solution().searchMatrix(matrix, 3));
    }

    //二分查找
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rows = matrix.length, cols = matrix[0].length, left = 0, right = rows * cols - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1),
                        row = mid / cols, col = mid % cols;
                int curr = matrix[row][col];
                if (curr == target) return true;
                if (curr > target) right = mid - 1;
                else left = mid + 1;
            }
            return false;
        }
    }
}
