package com.david.com.david.day.d11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * <p>
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * <p>
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * <p>
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * <p>
 * 示例：
 * <p>
 * n = 15,
 * <p>
 * 返回:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FizzBuzz_412 {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(16));
        System.out.println(fizzBuzz1(16));
    }

    public static List<String> fizzBuzz(int n) {
        return IntStream.rangeClosed(1, n).parallel().mapToObj(s -> s % 15 == 0 ? "FizzBuzz" : s % 5 == 0 ? "Buzz" : s % 3 == 0 ? "Fizz" : String.valueOf(s)).collect(Collectors.toList());
    }

    public static List<String> fizzBuzz1(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i >= 15 & i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
