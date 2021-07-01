package com.david.algo.basic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: david
 * @date: 2021/7/5
 */
public class CountOfAtoms_726 {
    public static void main(String[] args) {
//        System.out.println(new CountOfAtoms_726().new Solution().countOfAtoms("H2O"));//H2O
        System.out.println(new CountOfAtoms_726().new Solution().countOfAtoms("K4(ON(SO3)2)2"));//K4N2O14S4
//        System.out.println(new CountOfAtoms_726().new Solution().countOfAtoms("Mg(OH)2"));//H2MgO2
    }

    /**
     * 复制官方题解
     */
    class Solution {
        int i, n;
        String formula;

        public String countOfAtoms(String formula) {
            this.i = 0;
            this.n = formula.length();
            this.formula = formula;

            Deque<Map<String, Integer>> stack = new LinkedList<Map<String, Integer>>();
            stack.push(new HashMap<String, Integer>());
            while (i < n) {
                char ch = formula.charAt(i);
                if (ch == '(') {
                    i++;
                    stack.push(new HashMap<String, Integer>()); // 将一个空的哈希表压入栈中，准备统计括号内的原子数量
                } else if (ch == ')') {
                    i++;
                    int num = parseNum(); // 括号右侧数字
                    Map<String, Integer> popMap = stack.pop(); // 弹出括号内的原子数量
                    Map<String, Integer> topMap = stack.peek();
                    for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                        String atom = entry.getKey();
                        int v = entry.getValue();
                        topMap.put(atom, topMap.getOrDefault(atom, 0) + v * num); // 将括号内的原子数量乘上 num，加到上一层的原子数量中
                    }
                } else {
                    String atom = parseAtom();
                    int num = parseNum();
                    Map<String, Integer> topMap = stack.peek();
                    topMap.put(atom, topMap.getOrDefault(atom, 0) + num); // 统计原子数量
                }
            }

            Map<String, Integer> map = stack.pop();
            TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(map);

            StringBuffer sb = new StringBuffer();
            for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
                String atom = entry.getKey();
                int count = entry.getValue();
                sb.append(atom);
                if (count > 1) sb.append(count);
            }
            return sb.toString();
        }

        public String parseAtom() {
            StringBuffer sb = new StringBuffer();
            sb.append(formula.charAt(i++)); // 扫描首字母
            while (i < n && Character.isLowerCase(formula.charAt(i))) {
                sb.append(formula.charAt(i++)); // 扫描首字母后的小写字母
            }
            return sb.toString();
        }

        public int parseNum() {
            if (i == n || !Character.isDigit(formula.charAt(i))) {
                return 1; // 不是数字，视作 1
            }
            int num = 0;
            while (i < n && Character.isDigit(formula.charAt(i))) {
                num = num * 10 + formula.charAt(i++) - '0'; // 扫描数字
            }
            return num;
        }
    }


    /**
     * TODO 自己实现还有bug 跑不过
     * 使用栈去括号+map计数
     * 复制展开括号里的内容
     */
    class Solution1 {
        public String countOfAtoms(String formula) {
            char[] chars = formula.toCharArray();
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < chars.length; ) {
                if (chars[i] == ')') {//有括号
                    char repeat = chars[++i];//i++ 多走一步
                    StringBuilder tmp = new StringBuilder();
                    while (!"(".equals(stack.peek())) {//取最近一个括号
                        tmp.append(stack.pop());
                    }
                    stack.pop();
                    while (repeat-- > '0') {
                        for (char c : tmp.toString().toCharArray()) {
                            stack.push(String.valueOf(c));
                        }
                    }
                } else if (chars[i] >= '1' && chars[i] <= '9') {//数字
                    while (chars[i]-- > '1') {//复制前面的串 由于前面push过一次了 所以-1
                        stack.push(String.valueOf(chars[i - 1]));
                    }
                } else {//字母是一个大写后面跟0-n小写
                    StringBuilder tmp = new StringBuilder().append(chars[i]);
                    while (i + 1 < chars.length && chars[i + 1] >= 'a' && chars[i + 1] <= 'z') {
                        tmp.append(chars[i + 1]);
                        i++;
                    }
                    stack.push(tmp.toString());
                }
                i++;
            }
            Map<String, Long> counts = stack.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            StringBuilder sb = new StringBuilder();
            counts.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey().substring(0, 1))).forEach(e -> {
                sb.append(e.getKey());
                if (e.getValue() > 1) sb.append(e.getValue());
            });
            return sb.toString();
        }
    }
}
