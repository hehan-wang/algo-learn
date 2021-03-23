package com.david.algo.basic;

public class MergeTwoLists_21 {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val < l2.val) {//l1 对头小 l1.next=剩余合并队列
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;//返回对头元素
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

}
