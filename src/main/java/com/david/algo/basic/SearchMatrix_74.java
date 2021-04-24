package com.david.algo.basic;

/**
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 */
public class SearchMatrix_74 {

    //二分法
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int cols = matrix.length, rows = matrix[0].length, left = 0, right = rows * cols - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1), c = mid % rows, r = mid / rows;
                int curr = matrix[r][c];
                if (curr == target) return true;
                else if (curr > target) right = mid - 1;
                else left = mid + 1;
            }
            return false;
        }
    }
}
