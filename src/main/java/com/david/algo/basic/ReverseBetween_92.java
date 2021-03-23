package com.david.algo.basic;

/**
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class ReverseBetween_92 {

    /**
     * 头插法
     * 1.定义dummy虚节点 dummy.next=head
     * 2.先指针移动到到要翻转的头部
     * 3.头插法right-left次
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || head.next == null) return head;//少于一个元素返回自己
            ListNode dummy = new ListNode();
            dummy.next = head;
            int count = 1;
            ListNode pre = dummy, curr = dummy.next;//pre存前方正序链表的最后一个  curr存需要反转的第一个
            while (count++ < left) {//移动到要插入的位置
                pre = pre.next;
                curr = curr.next;
            }
            while (count++ <= right) {
                ListNode next = curr.next;
                curr.next = curr.next.next;
                next.next = pre.next;//为什么是pre.next 不是curr
                pre.next = next;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res = new ReverseBetween_92().new Solution().reverseBetween(head, 2, 4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
