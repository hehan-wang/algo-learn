package com.david.algo.window;

import java.util.HashMap;
import java.util.function.BiFunction;

/**
 * 76. 最小覆盖子串
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * https://leetcode-cn.com/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/
 */
public class MinWindow_76 {
    public static void main(String[] args) {
        System.out.println(new MinWindow_76().new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinWindow_76().new Solution1().minWindow("ADOBECODEBANC", "ABC"));
    }


    /**
     * 思路 滑动窗口
     * 1.使用一个int[128] 缓存存储需要字符和次数的关系 使用一个needCnt 存储需要的个数
     * 2.双指针left right 先移动right 直到needCnt==0。先找到窗口，在移动left 使窗口最小。
     * 3.再右移1个right 寻找下个
     * time:O(n)
     */
    class Solution {
        public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
            int[] need = new int[128];//下标为char need[char]存次数。 大小写字符128个ascii码 128足够
            int needCnt = t.length(), len = s.length(), l = 0, r = 0, start = 0, size = Integer.MAX_VALUE;
            char[] chars = s.toCharArray();
            for (char c : t.toCharArray()) need[c]++;//t 放入need中
            while (r < len) {
                char c = chars[r];
                if (need[c] > 0) {//在t中是需要的字符
                    needCnt--;
                }
                need[c]--;
                if (needCnt == 0) {//找到了窗口 缩小窗口
//                    System.out.println("1-》" + s.substring(l, r + 1));
                    //这里有两种情况,一种是区间不需要的字符,还有一种是重复的需要字符
                    //总之就是去掉冗余的字符,缩小区间
                    while (l < r && need[chars[l]] < 0) {
                        need[chars[l]]++;
                        l++;
                    }
//                    System.out.println("2-》" + s.substring(l, r + 1));
                    if (r - l + 1 < size) {//存最小size的 长度和开始位置
                        size = r - l + 1;
                        start = l;
                    }
                    //向右移动窗口 因为上一步已经把多余的字符去掉了 再右移肯定是会把需要的字符移调的所以 need[chars[l]]++;
                    need[chars[l]]++;
                    l++;
                    needCnt++;
                }
                r++;
            }
            return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
        }
    }

    //标准答案
    class Solution1 {
        public String minWindow(String s, String t) {

            if (s == null || s.length() == 0 || t == null || t.length() == 0) {
                return "";
            }
            //定义字符数组,注意保存的字符相等于下标i,比如保存了'A',相当于need[65] = 1
            int[] need = new int[128];
            //保存所需要的字符个数,也即对应的ASCII码作为下标的值
            for (int i = 0; i < t.length(); i++) {
                need[t.charAt(i)]++;
            }
            //l左边界,r右边界,size有效窗口大小,count需要字符个数,start为有效窗口的开始下标
            int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
            while (r < s.length()) {
                char c = s.charAt(r);
                if (need[c] > 0) {//说明该字符我们需要
                    count--;
                }
                //这里将r遍历的字符都加入到了窗口中,如果是无关的字符会变成负数
                //如果是需要的字符就会减一,出现多余的也会变成负数
                need[c]--;
                if (count == 0) {//说明区间已经拿到了所有需要的字符
                    //这里有两种情况,一种是区间不需要的字符,还有一种是重复的需要字符
                    //总之就是去掉冗余的字符,缩小区间
                    while (l < r && need[s.charAt(l)] < 0) {
                        need[s.charAt(l)]++;
                        l++;
                    }
                    if (r - l + 1 < size) {//更新有效区间的最小值
                        size = r - l + 1;
                        start = l;
                    }
                    //将左边界右移,由于减少了一位需要的字符,所以都要加1
                    need[s.charAt(l)]++;
                    l++;
                    count++;
                }
                //右边界右移
                r++;
            }
            return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
        }
    }
}
