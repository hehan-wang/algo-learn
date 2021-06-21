package com.david.algo.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * 1111 四位表示小时 0-11
 * 111111 六位表示分钟0-59
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * 思路
 * 1.回溯 求n个排列
 * 2.遍历 小时分种 判断位数
 * 3.遍历 2^10个位 1024 判断小时分钟
 */
public class ReadBinaryWatch_401 {
    public static void main(String[] args) {
        System.out.println((1 << 6) - 1);
        System.out.println(new ReadBinaryWatch_401().new Solution().readBinaryWatch(1));
        System.out.println(new ReadBinaryWatch_401().new Solution1().readBinaryWatch(1));
//        System.out.println(new ReadBinaryWatch_401().new Solution2().readBinaryWatch(1));
        System.out.println(new ReadBinaryWatch_401().new Solution2().readBinaryWatch(9));
    }

    /**
     * 遍历时间
     * O(1) 720次
     */
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            ArrayList<String> res = new ArrayList<>();
            for (int i = 0; i <= 11; i++) {
                for (int j = 0; j <= 59; j++) {
                    if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
//                        StringBuilder sb = new StringBuilder();
//                        sb.append(i).append(':');
//                        if (j < 10) sb.append('0');
//                        sb.append(j);
//                        res.add(sb.toString());
                        res.add(i + ":" + (j < 10 ? "0" + j : j));
                    }
                }
            }
            return res;
        }
    }

    /**
     * 遍历
     * 因为4(小时位)+6(分钟位)遍历2^10次
     * O(1) 1024次
     */
    class Solution1 {
        public List<String> readBinaryWatch(int turnedOn) {
            ArrayList<String> res = new ArrayList<>();
            int shift = (1 << 6) - 1;//取后6位
            for (int i = 0; i < 1024; i++) {
                int h = i >> 6, m = i & shift;
                if (h < 12 && m < 60 && bitCount(i) == turnedOn)
                    res.add(h + ":" + (m < 10 ? "0" + m : m));

            }
            return res;
        }

        private int bitCount(int n) {
//            return Integer.bitCount(n);
            int count = 0;
            while (n > 0) {
                n &= (n - 1);//每次打掉最后一位的1 到0的时候为把1都拿出来
                count++;
            }
            return count;
        }
    }

    /**
     * 回溯
     * 一共十个位置取turnedOn个
     */
    class Solution2 {
        ArrayList<String> res = new ArrayList<>();
        int[] hs = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
        int[] ms = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};

        public List<String> readBinaryWatch(int turnedOn) {
            backtrack(turnedOn, 0, 0, 0);
            return res;
        }

        private void backtrack(int n, int index, int h, int m) {
            if (h > 11 || m > 59) return;//超过最大值了返回
            if (n == 0) {//拿够turnedOn次了返回
//                res.add(h + ":" + (m < 10 ? "0" : "") + m);
                // 进行字符串拼接比直接拼接快很多
                StringBuilder sb = new StringBuilder();
                sb.append(h).append(':');
                if (m < 10) sb.append('0');
                sb.append(m);
                res.add(sb.toString());
                return;
            }
            for (int i = index; i < 10; i++) {
                backtrack(n - 1, i + 1, h + hs[i], m + ms[i]);
            }
        }
    }

}
