package com.david.day.d57;

public class ReverseStr_541 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefg", 2));
    }

    /**
     * 0 2k 4k的下标开始翻转
     */
    static class Solution {
        public String reverseStr(String s, int k) {
            char[] a = s.toCharArray();
            for (int start = 0; start < a.length; start += (k << 1)) {
                int i = start, j = Math.min(start + k - 1, a.length - 1);//优化右边界判断 最后剩余的小于k的翻转
                while (i < j) {
                    char tmp = a[i];
                    a[i++] = a[j];
                    a[j--] = tmp;
                }
            }
            return new String(a);
        }
    }
}
