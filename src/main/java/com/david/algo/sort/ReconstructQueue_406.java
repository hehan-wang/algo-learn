package com.david.algo.sort;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 406. 根据身高重建队列
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * 解释：
 * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
 */
public class ReconstructQueue_406 {

    /**
     * 解题思路：先排序再插入
     * 1.排序规则：按照先H高度降序，K个数升序排序
     * 2.遍历排序后的数组，根据K插入到K的位置上
     * <p>
     * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     * <p>
     * // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
     * // 再一个一个插入。
     * // [7,0]
     * // [7,0], [7,1]
     * // [7,0], [6,1], [7,1]
     * // [5,0], [7,0], [6,1], [7,1]
     * // [5,0], [7,0], [5,2], [6,1], [7,1]
     * // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
     * <p>
     * * https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/406-gen-ju-shen-gao-zhong-jian-dui-lie-java-xian-p/
     * time: java 排序使用快拍 O(nlogn) 遍历people 查找p的位置O(n^2) 总体O(n^2)
     */
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));//先按身高倒序 后按前面人正序
            var res = new LinkedList<int[]>();
            for (int[] p : people) {
                res.add(p[1], p);
            }
            return res.toArray(people);
        }
    }
}
