package com.sankiid.dynamic;

/**
 * Created by sandeep on 21/2/17.
 * <p>
 * Given a value V, if we want to make change for V cents, and we have infinite
 * supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum
 * number of coins to make the change?
 * </p>
 */
public class CoinChange1 {
	public static void main(String[] args) {
		int[] arr = { 3, 2, 5 };
		int n = 7;
		System.out.print(findMinCoinDenominationsToMakeChange(arr, n));
	}

	private static int findMinCoinDenominationsToMakeChange(int[] arr, int n) {
		if (n <= 0)
			return 0;
		if (arr == null)
			return 0;
		int[] tmp = new int[n + 1];
		tmp[0] = 0;
		for (int i = 1; i <= n; ++i) {
			tmp[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= n; ++i) {
			for (int j = 0; j < arr.length; ++j) {
				if (arr[j] <= i) {
					int va = tmp[i - arr[j]];
					if (va != Integer.MAX_VALUE && va + 1 < tmp[i])
						tmp[i] = va + 1;
				}
			}
		}

		return tmp[n];
	}
}
