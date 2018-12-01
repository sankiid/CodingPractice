package com.sankiid.dynamic;

public class BSTCount {

	public static void main(String[] args) {
		int count = countBst(6, new int[1000]);
		System.out.println(count);
	}

	private static int countBst(int n, int[] tmp) {
		if (n == 0 || n == 1)
			return 1;
		int allSolutions = 0;
		// Find all BST with root i
		for (int i = 1; i <= n; ++i) {
			if (tmp[i - 1] == 0) {
				tmp[i - 1] = countBst(i - 1, tmp);
			}
			if (tmp[n - i] == 0) {
				tmp[n - i] = countBst(n - i, tmp);
			}
			allSolutions += tmp[i - 1] * tmp[n - i];
		}
		return allSolutions;
	}

}
