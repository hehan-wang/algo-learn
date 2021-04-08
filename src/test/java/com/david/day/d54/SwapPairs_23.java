package com.david.day.d54;

/**
 * 思路
 * 1.递归
 * 子问题为翻转链表 尾结点连接下一翻转子链
 * 1-2-3-4
 * 2-1-4-3
 */
public class SwapPairs_23 {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode next = head.next;//next节点
            head.next = swapPairs(next.next);//当前节点-> 子链
            next.next = head;//翻转链表
            return next;
        }
    }


    public class ListNode {
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
