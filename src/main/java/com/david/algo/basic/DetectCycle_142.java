package com.david.algo.basic;

/**
 * 快慢指针
 * 第一次相遇
 * f=2s 快指针是慢指针的两倍
 * f=s+nb 快指针比慢指针多走n圈
 * >>> s=nb 关键！！！
 * a+nb为入口处
 * s再走a长度即可(s+a)
 * 把fast移动到对头 f=a s=nb+a
 * 再次相遇找到环入口
 */
public class DetectCycle_142 {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) return null;
            ListNode fast, slow;
            for (fast = head.next.next, slow = head.next;
                 fast != slow;
                 fast = fast.next.next, slow = slow.next) {
                if (fast == null || fast.next == null) return null;//fast走到头了 无环
            }
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
