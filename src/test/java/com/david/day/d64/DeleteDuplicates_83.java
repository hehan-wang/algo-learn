package com.david.day.d64;

//2021-03-08
public class DeleteDuplicates_83 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(1, new ListNode(1)));

        ListNode head = new Solution().deleteDuplicates(node);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 当next.val==curr.val  curr.next=curr.next.next
     */
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode curr = head;
            while (curr != null && curr.next != null) {
                if (curr.val == curr.next.val) curr.next = curr.next.next;
                else curr = curr.next;
            }
            return head;
        }
    }

    static public class ListNode {
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
