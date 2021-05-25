package com.david.algo.linkedlist;

import com.david.algo.basic.ListNode;
/**
 * 83. 删除排序链表中的重复元素
 */
public class DeleteDuplicates_83 {
    /**
     * 当前节点和下一个相等的时候偏移两个位置
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode curr = head;
            while (curr != null && curr.next != null) {
                if (curr.val == curr.next.val) curr.next = curr.next.next;//curr和next相等 不移动curr 移动next去重
                else curr = curr.next;//不等curr向后移动
            }
            return head;
        }
    }
}
