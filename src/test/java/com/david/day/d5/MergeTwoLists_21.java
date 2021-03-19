package com.david.day.d5;

public class MergeTwoLists_21 {

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

    /**
     * 递归
     * 子问题
     * l1小就l1.next=后续的有链表
     * l2同理
     */
    class Solution1 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //tetminator
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            //process
            //drill down
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
            //revert states
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode head = dummy;
            for (; l1 != null && l2 != null; head = head.next) {
                if (l1.val < l2.val) {
                    head.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    head.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            for (; l1 != null; l1 = l1.next, head = head.next) head.next = new ListNode(l1.val);
            for (; l2 != null; l2 = l2.next, head = head.next) head.next = new ListNode(l2.val);

            return dummy.next;
        }
    }
}
