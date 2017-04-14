package com.sankiid.dynamic;

/**
 * Created by sankiid on 13-03-2017.
 */
public class SubsetSum {
	public static void main(String[] args) {
		int[] set = { 1, 3, 9, 2 };
		int S = 6;
		boolean flag = subsetSum(set, S);
		System.out.println(flag);
	}

	private static boolean subsetSum(int[] set, int S) {
		boolean[][] matrix = new boolean[set.length + 1][S + 1];
		for (int i = 0; i <= set.length; ++i) {
			matrix[i][0] = true;
		}
		for (int j = 1; j <= S; ++j) {
			matrix[0][j] = false;
		}
		for (int i = 1; i <= set.length; ++i) {
			for (int j = 1; j <= S; ++j) {
				boolean f1 = matrix[i - 1][j];
				int id = j - set[i - 1];
				boolean f2 = id < 0 ? false : matrix[i - 1][id];
				matrix[i][j] = f1 | f2;
			}
		}
		return matrix[set.length][S];
	}
}
