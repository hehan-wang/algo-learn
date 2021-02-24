package com.david.day.d35;

import java.util.Collections;
import java.util.stream.Collectors;

public class ReplaceSpace_offer05 {
    public static void main(String[] args) {
        System.out.println(new Solution1().replaceSpace("We are happy."));
    }

    /**
     * lambda一行解决
     */
    static class Solution1 {
        public String replaceSpace(String s) {
            return s.chars().mapToObj(i -> (char) i).map(c -> c == ' ' ? "%20" : String.valueOf(c)).collect(Collectors.joining());
        }
    }

    static class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') sb.append("%20");
                else sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }
}
