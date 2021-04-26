package com.david.algo.basic;

public class RemoveNthFromEnd_19 {
    /**
     * 双指针
     * fast比slow快n
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1), fast = dummy, slow = dummy, pre = dummy;//使用dummy节点
            dummy.next = head;
            while (n-- > 0) {
                fast = fast.next;
            }
            while (fast != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next;
            }
            pre.next = slow.next;
            return dummy.next;
        }
    }
}
