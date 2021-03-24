package com.david.algo.basic;

import java.util.LinkedList;

/**
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步:0->1->2->NULL
 * 向右旋转 4 步:2->0->1->NULL
 */
public class RotateRight_61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        head = new RotateRight_61().new Solution1().rotateRight(head, 2);
        for (; head != null; head = head.next) System.out.println(head.val);
    }


    /**
     * 先成环 在切断
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * n=5 k=2
     * (n - k % n) - 1 = 2 尾巴向后走两次
     * O(n)
     */
    class Solution1 {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) return head;
            ListNode tail = head;
            int n = 1;
            for (; tail.next != null; tail = tail.next, n++) ;
            tail.next = head;//形成环
            ListNode newTail = head;
            for (int i = 0; i < (n - k % n) - 1; i++) {  //找到尾巴下标
                newTail = newTail.next;
            }
            //切断环
            ListNode newHead = newTail.next;
            newTail.next = null;
            return newHead;
        }
    }

    /**
     * 使用双端队列
     * 超出时间限制
     * O(n)
     */
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) return head;
            LinkedList<ListNode> deque = new LinkedList<>();
            //链表放入队列
            for (ListNode curr = head; curr != null; curr = curr.next) {
                deque.addLast(curr);
            }
            k = k % deque.size();//过滤掉整圈的
            ListNode h = head, pre, tail;//分别存头 倒数第一个 倒数第二个元素
            while (k-- > 0) {
                tail = deque.removeLast();//队列尾部的为要移动到最前面的元素
                pre = deque.peekLast();
                deque.addFirst(tail);//队尾元素放入对头
                //链表移动
                tail.next = h;
                pre.next = null;
                h = tail;
            }
            return h;
        }
    }
}
