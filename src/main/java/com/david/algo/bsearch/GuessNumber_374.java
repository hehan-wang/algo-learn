package com.david.algo.bsearch;

/**
 * 374. 猜数字大小
 */
public class GuessNumber_374 {
    /**
     * 使用二分法
     */
    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int left = 1, right = n;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                int pick = guess(mid);
                if (pick == 0) return mid;
                else if (pick == 1) right = mid;
                else if (pick == -1) left = mid + 1;
            }
            return -2;
        }
    }

    private class GuessGame {
        int guess(int num) {
            return -1;
        }
    }
}
