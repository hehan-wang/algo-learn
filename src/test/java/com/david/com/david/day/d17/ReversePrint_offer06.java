package com.david.com.david.day.d17;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class ReversePrint_offer06 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(2)));
        int[] res = new Solution().reversePrint(head);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 思路
     * 1.遍历链表放在栈中
     *
     * time:O(n) 遍历一次数组
     * space:O(n)额外空间
     */
    static class Solution {
        public int[] reversePrint(ListNode head) {
            LinkedList<ListNode> stack = new LinkedList<>();
            while (head != null) {
                stack.push(head);
                head = head.next;
            }
            int[] res = new int[stack.size()];
            int i = 0;
            while (!stack.isEmpty()) {
                res[i++] = stack.pop().val;
            }
            return res;
        }
    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
