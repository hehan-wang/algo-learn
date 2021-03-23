package com.david.algo.basic;

import java.util.HashSet;

/**
 * 思路
 * 1.快慢指针
 * 2.set判重
 */
public class HasCycle_141 {
    public class Solution1 {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;//空链表或者只有1个元素
            for (ListNode fast = head.next.next, slow = head.next;//相当于do while
                 fast != null && fast.next != null;
                 fast = fast.next.next, slow = slow.next) {
                if (fast == slow) return true;
            }
            return false;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            HashSet<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) return true;
                set.add(head);
                head = head.next;
            }
            return false;
        }
    }

}
