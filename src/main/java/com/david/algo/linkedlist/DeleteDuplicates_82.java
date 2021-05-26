package com.david.algo.linkedlist;

import com.david.algo.basic.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 */
public class DeleteDuplicates_82 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))));
        ListNode.print(root);
        System.out.println();
        ListNode.print(new DeleteDuplicates_82().new Solution().deleteDuplicates(root));
        System.out.println();
        ListNode.print(new DeleteDuplicates_82().new Solution1().deleteDuplicates(root));
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(), curr = dummy;
            while (head != null) {
                // 进入循环时，确保了 head 不会与上一节点相同
                if (head.next == null || head.val != head.next.val) {
                    curr.next = head;
                    curr = curr.next;
                }
                // 如果 head 与下一节点相同，跳过相同节点
                while (head.next != null && head.val == head.next.val) head = head.next;
                head = head.next;
            }
            curr.next = null;
            return dummy.next;
        }
    }

    /**
     * 思路
     * 1.先找到curr后面出现相等的节点
     * 2.删除连续的curr后的值相等的节点
     */
    class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            ListNode dummy = new ListNode(-1, head), curr = dummy;
            while (curr.next != null && curr.next.next != null) {
                if (curr.next.val == curr.next.next.val) {//找到后面出现重复curr
                    int x = curr.next.val;
                    while (curr.next != null && x == curr.next.val) {//链表删除重复的(val===x)的
                        curr.next = curr.next.next;
                    }
                } else {
                    curr = curr.next;//正常迭代
                }
            }
            return dummy.next;
        }
    }
}
