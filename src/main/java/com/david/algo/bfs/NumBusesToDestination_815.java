package com.david.algo.bfs;

import java.util.*;
import java.util.function.Function;

/**
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 */
public class NumBusesToDestination_815 {
    public static void main(String[] args) {
        System.out.println(new NumBusesToDestination_815().new Solution().numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));//2
        System.out.println(new NumBusesToDestination_815().new Solution().numBusesToDestination(new int[][]{{1, 7}, {3, 5}}, 5, 5));//0
    }

    /**
     * 思路
     * 先找到source可以坐哪辆公交，然后看从各站下转车能到哪。想到使用bfs一层一层向外延伸
     * 1.缓存 车站->路线Set的映射关系来转车用，缓存路线->车站Set 为了把list O(n)的搜索降低到O(1)。
     * 2.bfs 搜索
     */
    class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            //1.缓存到map中
            HashMap<Integer, Set<Integer>> station2routes = new HashMap<>();//缓存 车站->路线集合到map中
            HashMap<Integer, Set<Integer>> routes2stations = new HashMap<>();//缓存 路线->车站集合到map中 使用set加速O(1)查找
            for (int i = 0; i < routes.length; i++) {
                HashSet<Integer> stations = new HashSet<>();
                for (int station : routes[i]) {
                    stations.add(station);
                    station2routes.computeIfAbsent(station, integer -> new HashSet<>()).add(i);//不存在创建新set 存在把车次放入set
                }
                routes2stations.put(i, stations);
            }
            //2.判断特殊情况
            if (!station2routes.containsKey(source) || !station2routes.containsKey(target)) return -1;//没有起始节点肯定到不了
            if (station2routes.get(target) == station2routes.get(source)) return 0;//在一个车上
            //3.bfs
            int count = 0;
            Queue<Integer> queue = new LinkedList<>(station2routes.get(source));    //存搜索的车次
            HashSet<Integer> seen = new HashSet<>();//做过的车次
            while (!queue.isEmpty()) {
                count++;
                int size = queue.size();
                while (size-- > 0) {
                    Integer curr = queue.poll();//拿出当前车次
                    seen.add(curr);
                    Set<Integer> stations = routes2stations.get(curr);//取当前车对应的车站
                    if (stations.contains(target)) return count;//找到了
                    for (Integer station : stations) {
                        Set<Integer> rs = station2routes.get(station);
                        for (Integer r : rs) {
                            if (seen.contains(r)) continue;//当前车做过不再做
                            queue.offer(r);
                        }
                    }
                }
            }
            return -1;
        }
    }
}
