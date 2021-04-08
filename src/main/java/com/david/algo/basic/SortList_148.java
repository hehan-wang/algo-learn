package com.david.algo.basic;

public class SortList_148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode h = new SortList_148().new Solution1().sortList(head);
        for (; h != null; h = h.next) System.out.println(h.val);
    }

    class Solution1 {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode fast = head.next, slow = head;
            for (; fast != null && fast.next != null; fast = fast.next.next, slow = slow.next) ;
            ListNode mid = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
            ListNode h = new ListNode(), res = h;
            for (; left != null && right != null; h = h.next) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
            }
            h.next = right != null ? right : left;
            return res.next;
        }
    }

    /**
     * 归并排序
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode mid = slow.next;
            slow.next = null;//切断链表
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
            //merge
            ListNode h = new ListNode();
            ListNode res = h;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
                h = h.next;
            }
            h.next = left != null ? left : right;
            return res.next;
        }
    }
}
