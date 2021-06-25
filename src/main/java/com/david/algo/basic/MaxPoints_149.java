package com.david.algo.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * 149. 直线上最多的点数
 */
public class MaxPoints_149 {
    public static void main(String[] args) {
//        System.out.println(new MaxPoints_149().new Solution().gcd(1, 0));
    }

    class Solution {
        public int maxPoints(int[][] points) {
            int n = points.length;
            if (n <= 2) {//两点成线
                return n;
            }
            int ret = 0;
            for (int i = 0; i < n; i++) {//枚举左右边界
                if (ret >= n - i || ret > n / 2) {
                    break;
                }
                Map<Integer, Integer> map = new HashMap<>();//存当前左右边界情况下各个斜率的点的个数
                for (int j = i + 1; j < n; j++) {
                    int x = points[i][0] - points[j][0];
                    int y = points[i][1] - points[j][1];
                    if (x == 0) y = 1;
                    else if (y == 0) x = 1;
                    else {
                        if (y < 0) {// 打平 1/-2   -1/2 这种情况
                            x = -x;
                            y = -y;
                        }
                        int gcdXY = gcd(Math.abs(x), Math.abs(y));
                        x /= gcdXY;
                        y /= gcdXY;
                    }
                    int key = y + x * 20001;//由于 x y最大值为 +/-10000 所以*20001进行编码
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
                int cnt = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int num = entry.getValue();
                    cnt = Math.max(cnt, num + 1);
                }
                ret = Math.max(ret, cnt);
            }
            return ret;
        }

        //计算最大公约数 没有的话返回1
        public int gcd(int a, int b) {
            return b != 0 ? gcd(b, a % b) : a;
        }
    }

}
