package com.david.algo.sort;

import com.david.algo.basic.ListNode;

import java.util.*;

/**
 * 143. 重排链表
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 思路
 * 1.双指针 先把链表入双端队列？不符合原地交换要求 X
 * 2.链表入栈 出栈插入
 */
public class ReorderList_143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode.print(head);
        new ReorderList_143().new Solution().reorderList(head);
        ListNode.print(head);
    }

    /**
     * TODO
     * 使用栈
     */
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;//0个或者1个元素
            Stack<ListNode> stack = new Stack<>();
            ListNode curr = head;
            while (curr != null) {
                stack.push(curr);
                curr = curr.next;
            }
            curr = head;
            int size = stack.size();//节点数量
            while (size >= 0) {
                ListNode next = curr.next;
                ListNode tail = stack.pop();
                curr.next = tail;
                tail.next = next;
                curr = next;
                size -= 2;
            }
        }
    }
}
