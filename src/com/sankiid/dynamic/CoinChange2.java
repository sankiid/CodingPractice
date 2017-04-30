package com.sankiid.dynamic;

/**
 * Created by sandeep on 22/2/17.
 * <p>
 * Given a value N, if we want to make change for N cents, and we have infinite
 * supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we
 * make the change? The order of coins doesn’t matter.
 */
public class CoinChange2 {

	public static void main(String[] args) {
		int arr[] = { 2, 5, 3 };
		long c = countOptimized(arr, 1);
		System.out.print(c);
	}

	private static int count(int[] arr, int i, int j, int sum) {
		if (i > j || sum < 0)
			return 0;
		if (sum == 0)
			return 1;
		return count(arr, i, j, sum - arr[i]) + count(arr, i + 1, j, sum);
	}

	private static long countOptimized(int[] arr, int sum) {
		long[] table = new long[sum + 1];
		table[0] = 1;
		
		for (int i = 0; i < arr.length; i++)
			for (int j = arr[i]; j <= sum; j++)
				table[j] += table[j - arr[i]];

		return table[table.length - 1];
	}

}
