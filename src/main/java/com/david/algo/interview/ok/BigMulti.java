package com.david.algo.interview.ok;

import java.util.Scanner;

/**
 * 大数相乘 okcoin三面
 */
public class BigMulti {
    /**
     * 大数相乘基本思想，输入字符串，转成char数组，转成int数组。采用分治思想，每一位的相乘;<br>
     * 公式：AB*CD = AC (BC+AD) BD , 然后从后到前满十进位(BD,(BC+AD),AC)。
     *
     * @param num1
     * @param num2
     */
    public String multiply(String num1, String num2) {
        //把字符串转换成char数组
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        //存两数交叉相乘
        int[] result = new int[chars1.length + chars2.length];
        //逐个相乘，因为你会发现。AB*CD = AC(BC+AD)BD , 然后进位。
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                result[i + j] += (chars1[i] - '0') * (chars2[j] - '0');
            }
        }

        //满10进位，从后往前满十进位
        for (int i = result.length - 1; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        //转成string并返回
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < result.length - 1; i++) resultStr.append(result[i]);
        return resultStr.toString();
    }

    public static void main(String[] args) {
        BigMulti bm = new BigMulti();
        String num1 = "53";
        String num2 = "34";
        String result = bm.multiply(num1, num2);
        System.out.println("相乘结果为：" + result);
    }
}
