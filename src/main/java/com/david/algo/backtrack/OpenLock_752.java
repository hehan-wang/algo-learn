package com.david.algo.backtrack;

import java.util.*;

/**
 * 752. 打开转盘锁
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 */
public class OpenLock_752 {
    public static void main(String[] args) {
//        System.out.println(new OpenLock_752().new Solution().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(new OpenLock_752().new Solution().openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
    }




    /**
     * bfs
     * 每次bfs上次字符可以变换的串
     */
    class Solution {
        public int openLock(String[] deadends, String target) {
            if (target.equals("0000")) return 0;//不需要变换
            HashSet<String> ds = new HashSet<>();
            for (String d : deadends) ds.add(d);
            if (ds.contains("0000")) return -1;//上来就死了
            HashSet<String> seen = new HashSet<>();
            seen.add("0000");
            Queue<String> queue = new LinkedList<>();
            queue.offer("0000");
            int step = 0;//存步数
            while (!queue.isEmpty()) {
                step++;
                int size = queue.size();
                while (size-- > 0) {
                    String curr = queue.poll();
                    for (String s : nextStr(curr)) {
                        if (!seen.contains(s) && !ds.contains(s)) {//没搜过 而且不再障碍上
                            if (target.equals(s)) return step;
                            seen.add(s);
                            queue.offer(s);
                        }
                    }
                }
            }
            return -1;//没搜到
        }

        //从str变换的所有字符(8个)
        public List<String> nextStr(String str) {
            List<String> list = new ArrayList<>();
            char[] chars = str.toCharArray();//e.p. '0000'
            for (int i = 0; i < chars.length; i++) {
                char num = chars[i];//'0'
                //+1
                chars[i] = num == '9' ? '0' : (char) (num + 1);
                list.add(new String(chars));
                //-1
                chars[i] = num == '0' ? '9' : (char) (num - 1);
                list.add(new String(chars));
                chars[i] = num;//重置当前位，给下次循环其他位置用
            }
            return list;
        }
    }

    //双向bfs
}
