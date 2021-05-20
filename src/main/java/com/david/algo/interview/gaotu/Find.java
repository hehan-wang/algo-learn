package com.david.algo.interview.gaotu;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 */
public class Find {
    public static void main(String[] args) {
        System.out.println(new Find().new Solutin().find(new int[]{1, 2, 3, 2}));
    }

    public class Solutin {
        public Set<Integer> find(int[] arr) {
            Set<Integer> seen = Arrays.stream(arr).boxed().collect(Collectors.toSet());
            return IntStream.rangeClosed(1, arr.length).boxed().filter(s -> !seen.contains(s)).collect(Collectors.toSet());
        }
    }
//    public class Solutin {
//        //交换法 1-n 移动到对应自己的位置上
//        public int find(int[] arr) {
//            for (int i = 0; i < arr.length; ) {
//                int val = arr[i];
//                if (arr[val] == i) {
//                    i++;
//                    continue;
//                }
//                if (arr[val] == val) return val;//发现重复
//                //交换arr[val] arr[i]
//                int tmp = arr[val];
//                arr[val] = arr[i];
//                arr[i] = tmp;
//            }
//            return -1;
//        }
//    }
}
