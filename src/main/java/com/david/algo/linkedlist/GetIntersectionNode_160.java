package com.david.algo.linkedlist;

import com.david.algo.basic.ListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 1.暴力 cache headB到set中 遍历headA time:O(n+m) space:O(m)
 * 2.双指针 遍历a+b次如果存在的话交点的话一定会相遇
 */
public class GetIntersectionNode_160 {
    //使用map cache
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            HashSet<ListNode> set = new HashSet<>();
            while (headA != null) {
                set.add(headA);
                headA = headA.next;
            }
            while (headB != null) {
                if (set.contains(headB)) return headB;
                headB = headB.next;
            }
            return null;
        }
    }

    /**
     * 思路
     * time:O(a+b)
     * space:O(1)
     * 双指针 遍历a+b次如果存在的话交点的话一定会相遇  否则形同陌路两个人都是null
     */
    public class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA, b = headB;
            while (a != b) {//同为null 或者找到交点
                a = a != null ? a.next : headB;//a走完了去headB
                b = b != null ? b.next : headA;//b走完了去headA
            }
            return a;
        }
    }
}
