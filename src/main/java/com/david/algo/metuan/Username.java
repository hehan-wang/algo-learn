package com.david.algo.metuan;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * https://leetcode-cn.com/leetbook/read/meituan/ohsjgd/
 * <p>
 * 小美是美团的前端工程师，为了防止系统被恶意攻击，小美必须要在用户输入用户名之前做一个合法性检查，一个合法的用户名必须满足以下几个要求：
 * <p>
 * 用户名的首字符必须是大写或者小写字母。
 * 用户名只能包含大小写字母，数字。
 * 用户名需要包含至少一个字母和一个数字。
 * 如果用户名合法，请输出 "Accept"，反之输出 "Wrong"。
 *
 * <p>
 * 输入：
 * - 输入第一行包含一个正整数 T，表示需要检验的用户名数量。
 * - 接下来有 T 行，每行一个字符串 s，表示输入的用户名。
 * 输出：
 * - 对于每一个输入的用户名 s，请输出一行，即按题目要求输出一个字符串。
 * <p>
 * 输入：
 * 5
 * Ooook
 * Hhhh666
 * ABCD
 * Meituan
 * 6666
 * 输出：
 * Wrong
 * Accept
 * Wrong
 * Wrong
 * Wrong
 */
public class Username {
    public static class Solution {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int lines = scanner.nextInt();
            String pattern = "^([a-zA-z])([a-zA-z]*)([0-9]+)+([a-zA-z0-9]*)$";//(字母一次)(字母[0-n]次数字[1-n]次)(数字字母[0-n]次)
            while (lines-- >= 0) {
                String s = scanner.next();
                boolean matches = Pattern.matches(pattern, s);
                if (matches) System.out.println("Accept");
                else System.out.println("Wrong");
            }
        }
    }
}
