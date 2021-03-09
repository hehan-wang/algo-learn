package com.david.day.d62;

public class ValidPalindrome_680 {
    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("aba"));
        System.out.println(new Solution().validPalindrome("abca"));
    }

    /**
     * 双指针法 只能删除一个字符
     * i j 向中间夹逼
     * 相遇了本身为回文串
     * 否则删除左边或者右边继续判断
     * time:O(n)
     * space:O(n)
     */
    static class Solution {
        public boolean validPalindrome(String s) {
            char[] chars = s.toCharArray();
            int i = 0, j = chars.length - 1;
            for (; i < j && chars[i] == chars[j]; i++, j--) ;
            return i >= j || valid(i + 1, j, chars) || valid(i, j - 1, chars);
        }

        private boolean valid(int i, int j, char[] chars) {
            for (; i < j && chars[i] == chars[j]; i++, j--) ;
            return i >= j;
        }
    }
}
