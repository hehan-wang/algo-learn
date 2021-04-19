package com.david.day.d4;


public class SwapPairs_24 {
    /**
     * 每次返回链表头
     * 翻转链表尾指向下个链表头
     * 1->2->3->4
     * <p>
     * 2->1->4->3
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode next = head.next;//下一个节点
            head.next = swapPairs(next.next);//接下面next
            next.next = head;//翻转链表
            return next;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
