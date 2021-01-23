package com.david.com.david.day.d25;

public class LemonadeChange_860 {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(new Solution().lemonadeChange(bills));
    }

    /**
     * 傻穷举法
     */
    static class Solution {
        public boolean lemonadeChange(int[] bills) {
            int[] packet = new int[3];//钱包 0放5块，1放10块 2 放20块
            for (int bill : bills) {
                switch (bill) {
                    case 5://5块钱的单子直接收钱
                        packet[0] = packet[0] + 1;
                        break;
                    case 10://10块钱只要有5块就找5块
                        if (packet[0] > 0) {
                            packet[0] = packet[0] - 1;
                            packet[1] = packet[1] + 1;
                        } else {
                            return false;
                        }
                        break;
                    case 20:
                        if (packet[1] > 0 && packet[0] > 0) {//兜里都10块先找10块在找5块
                            packet[1] = packet[1] - 1;
                            packet[0] = packet[0] - 1;
                        } else if (packet[0] > 2) {//有三张5块才能找开
                            packet[0] = packet[0] - 3;
                            packet[2] = packet[2] + 1;
                        } else {
                            return false;
                        }
                        break;
                }
            }
            return true;
        }
    }
}
