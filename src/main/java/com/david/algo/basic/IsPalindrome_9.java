package com.david.algo.basic;

/**
 * 9. 回文数
 * 1.转化成字符串进行回文串查询
 * 2.数字原生查询
 */
public class IsPalindrome_9 {
    public static void main(String[] args) {
        System.out.println(new IsPalindrome_9().new Solution().isPalindrome(121));
        System.out.println(new IsPalindrome_9().new Solution().isPalindrome(-121));
        System.out.println("---------------------------------------------------------");
        System.out.println(new IsPalindrome_9().new Solution1().isPalindrome(121));
        System.out.println(new IsPalindrome_9().new Solution1().isPalindrome(-121));
    }

    //转化成字符串 O(n)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            String s = String.valueOf(x);
            for (int left = 0, right = s.length() - 1; left <= right; left++, right--) {
                if (s.charAt(left) != s.charAt(right)) return false;
            }
            return true;
        }
    }

    /**
     * 思路
     * 1.先计算出最高位在哪
     * 2.每次截取出最高位 最低位比较
     * 3.截掉最高位最低位
     */
    class Solution1 {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            int div = 1;
            while (x / div >= 10) div *= 10;//取出最高位 x=121 ->> div=1000
            while (x > 0) {
                int right = x % 10;
                int left = x / div;
                if (right != left) return false;
                x = (x % div) / 10;//去掉头尾
                div /= 100;
            }
            return true;
        }
    }
}
