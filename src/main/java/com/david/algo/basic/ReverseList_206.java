package com.david.algo.basic;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 递归
 * 循环
 */
public class ReverseList_206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode newHead = new ReverseList_206().new Solution().reverseList(head);
//        ListNode newHead = new ReverseList_206().new Solution1().reverseList(head);
        System.out.println(newHead);
    }

    //循环
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;//少于一个元素返回自己
            ListNode pre = null, curr = head;
            while (curr != null) {
                //翻转
                ListNode next = curr.next;
                curr.next = pre;//翻转curr和pre
                //迭代
                pre = curr;
                curr = next;
            }
            return pre;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode curr = reverseList(head.next);//从后向前 返回的一定是最后一个元素
            head.next.next = head;//翻转链表
            head.next = null;//防止循环链表
            return curr;
        }
    }

}
