package com.david.algo.basic;

/**
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class GetKthFromEnd_offer22 {
    /**
     * 走n-k步即为重点
     * 双指针 a先走k，b再走。
     * a走到n，b走n-k
     */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode first = head, second = head;
            while (k-- > 0) first = first.next;
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            return second;
        }
    }
}
