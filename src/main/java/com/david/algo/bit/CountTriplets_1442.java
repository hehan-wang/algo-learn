package com.david.algo.bit;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 */
public class CountTriplets_1442 {
    public static void main(String[] args) {
        System.out.println(new CountTriplets_1442().new Solution().countTriplets(new int[]{2, 3, 1, 6, 7}));
    }

    /**
     * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
     * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
     * a==b
     * 思路:
     * a^b=xor(i...k)=0 j在(i,k]区间任意值都可以
     * 枚举i k 计算xor(i..k)==0  题目只需要数量所以直接k-i
     */
    class Solution {
        public int countTriplets(int[] arr) {
            int res = 0, n = arr.length;
            for (int i = 0; i < n; i++) {//枚举i
                int xor = arr[i];
                for (int k = i + 1; k < n; k++) {//枚举k
                    xor ^= arr[k];
                    if (xor == 0) res += (k - i);
                }
            }
            return res;
        }
    }
}
