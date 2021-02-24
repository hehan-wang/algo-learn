package com.david.day.d31;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RobotSim_874 {
    public static void main(String[] args) {
        System.out.println(new Solution().robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
    }

    static class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int[][] ds = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//1.定义4个方向
            Set<String> obs = Arrays.stream(obstacles).map(a -> a[0] + " " + a[1]).collect(Collectors.toSet());//2.在、障碍物编码存入set
            int x = 0, y = 0, d = 0, res = 0;//定义坐标 方向
            for (int c : commands) { //3.遍历命令
                if (c == -1) d = (d + 1) % 4;
                else if (c == -2) d = (d + 3) % 4;
                else while (c-- > 0 && !obs.contains((x + ds[d][0]) + " " + (y + ds[d][1]))) {
                        x += ds[d][0];
                        y += ds[d][1];
                        res = Math.max(res, x * x + y * y);
                    }
            }
            return res;
        }
    }
}
