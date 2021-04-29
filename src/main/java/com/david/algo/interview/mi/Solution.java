package com.david.algo.interview.mi;


import java.util.*;

/**
 * 小米一面 排列问题
 * dfs
 */
public class Solution {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = new Solution().permute(new int[]{1, 2, 3});
		System.out.println(res);
	}

	ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		boolean[] used = new boolean[num.length];
		dfs(num, used, new ArrayList<>(), 0, num.length);
		return res;
	}

	private void dfs(int[] num, boolean[] used, ArrayList<Integer> tmp, int i, int n) {
		if (i == n) res.add(new ArrayList<>(tmp));
		for (int j = 0; j < num.length; j++) {
			if (used[j]) continue;
			tmp.add(num[j]);
			used[j] = true;
			dfs(num, used, tmp, i + 1, n);
			tmp.remove(tmp.size() - 1);
			used[j] = false;
		}
	}
}
