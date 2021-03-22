package com.david.algo.basic;

import java.util.HashMap;
import java.util.Objects;

public class WordPattern_290 {
    public static void main(String[] args) {
//        System.out.println(new WordPattern_290().new Solution().wordPattern("abba", "dog cat cat dog"));
//        System.out.println(new WordPattern_290().new Solution().wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(new WordPattern_290().new Solution().wordPattern("abba", "dog dog dog dog"));
        System.out.println(new WordPattern_290().new Solution1().wordPattern("abba", "dog dog dog dog"));
    }

    /*
     * 两个map
     */
    class Solution1 {
        public boolean wordPattern(String pattern, String s) {
            char[] chars = pattern.toCharArray();
            String[] strs = s.split(" ");
            if (chars.length != strs.length) return false;
            HashMap<Character, String> p2s = new HashMap<>();
            HashMap<String, Character> s2p = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                char p = chars[i];
                String str = strs[i];
                if (p2s.containsKey(p) && !Objects.equals(str, (p2s.get(p)))) return false;
                if (s2p.containsKey(str) && !Objects.equals(p, s2p.get(str))) return false;
                p2s.put(p, str);
                s2p.put(str, p);
            }
            return true;
        }
    }

    /**
     * 双向映射
     * 1.split s
     * 2.放在map里查找
     * map.put(k,v) 返回旧的v
     * 相同下标的元素需要对应
     * O(p+s)
     */
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");
            char[] chars = pattern.toCharArray();
            if (words.length != chars.length) return false;
            HashMap<Object, Integer> map = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                /*
                如果key不存在，插入成功，返回null；如果key存在，返回之前对应的value。

                以pattern = "abba", str = "dog cat cat dog"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("dog",3)返回0，两者相等，
                结果为 true。

                以pattern = "abba", str = "dog cat cat fish"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("fish",3)返回null，两者不相等，
                结果为 false。
              */
                if (!Objects.equals(map.put(chars[i], i), map.put(words[i], i))) return false;
            }
            return true;
        }
    }
}
