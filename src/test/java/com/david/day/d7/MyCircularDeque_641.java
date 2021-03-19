package com.david.day.d7;

public class MyCircularDeque_641 {

    /**
     * 数组实现
     * 头插 先-1 在插
     * 尾插 先插 在+1
     */
    class MyCircularDeque {
        int[] elements;
        int front = 0;//存头
        int rear = 0;//存尾的下一个指针
        int capacity;
        int size = 0;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            elements = new int[k];
            this.capacity = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) return false;
            front = (front - 1 + capacity) % capacity;//获取循环队列下一个下标  -1可能出现负数所以+capacity
            elements[front] = value;
            size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) return false;
            elements[rear] = value;
            rear = (rear + 1) % capacity;//
            size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) return false;
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) return false;
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            return isEmpty() ? -1 : elements[front];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            return isEmpty() ? -1 : elements[(rear - 1 + capacity) % capacity];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return capacity == size;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque_641().new MyCircularDeque(3);
        boolean param_1 = obj.insertFront(1);
        boolean param_2 = obj.insertLast(2);
        boolean param_3 = obj.deleteFront();
        boolean param_4 = obj.deleteLast();
        int param_5 = obj.getFront();
        int param_6 = obj.getRear();
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();
        System.out.println("---");
    }

}
