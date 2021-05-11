package com.david.algo.basic;

import java.util.Arrays;

public class Rotate_48 {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        print(matrix);
        new Rotate_48().new Solution().rotate(matrix);
        print(matrix);
    }

    public static void print(int[][] matrix) {
        Arrays.stream(matrix).forEach(l -> System.out.println(Arrays.toString(l)));
        System.out.println("----------------");
    }

    /**
     * 两次翻转法
     * 顺时针旋转90=主对角线翻转+左右翻转
     */
    class Solution {
        public void rotate(int[][] matrix) {
            int m = matrix.length;
            if (m == 0 || matrix[0].length == 0) return;
            int n = matrix[0].length;
            //主对角线翻转
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < i; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
            print(matrix);

            //左右翻转
            int mid = matrix[0].length >> 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < mid; j++) {
                    int j1 = n - j - 1;
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][j1];
                    matrix[i][j1] = tmp;
                }
            }
        }
    }
}
