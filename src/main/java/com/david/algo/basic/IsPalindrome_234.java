package com.david.algo.basic;

import java.util.LinkedList;

/**
 * 234. 回文链表
 * 输入: 1->2->2->1
 * 输出: true
 * 思路：
 * 1.成对问题使用栈 链表先入栈。然后stack.pop()和链表头对比 不等的话不是回文 O(2*n)
 * 2.快慢指针 找到中点 反转链表。对比前后是否相等 不等则返回false
 */
public class IsPalindrome_234 {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));
//        System.out.println(new IsPalindrome_234().new Solution1().isPalindrome(head));
        System.out.println(new IsPalindrome_234().new Solution().isPalindrome(head));
    }

    //使用栈 O(2n)
    class Solution1 {
        public boolean isPalindrome(ListNode head) {
            if (head == null) return false;
            LinkedList<Integer> stack = new LinkedList<>();
            for (ListNode curr = head; curr != null; curr = curr.next) {
                stack.push(curr.val);
            }
            for (ListNode curr = head; curr != null; curr = curr.next) {
                if (curr.val != stack.pop()) return false;
            }
            return true;
        }
    }

    /**
     * 使用快慢指针，快指针到尾部 慢指针正好到中间，翻转前半边链表，和后面比较 有不相等的即不是回文
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) return false;
            ListNode fast = head, slow = head, newHead = head, newPre = null;
            while (fast != null && fast.next != null) {
                newHead = slow;
                slow = slow.next;
                fast = fast.next.next;
                newHead.next = newPre;
                newPre = newHead;
            }
            if (fast != null) {// slow在前半部分尾部/或者奇数个元素的时候在中间元素位置 要移动一个到后半部分头部
                slow = slow.next;
            }

            while (slow != null && newHead != null) {
                if (slow.val != newHead.val) return false;//发现两个链表不相等直接返回false
                slow = slow.next;
                newHead = newHead.next;
            }

            return true;
        }
    }
}
