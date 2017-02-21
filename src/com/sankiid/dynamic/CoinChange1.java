package com.sankiid.dynamic;

/**
 * Created by sandeep on 21/2/17.
 * <p>
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm}
 * valued coins, what is the minimum number of coins to make the change?
 * </p>
 */
public class CoinChange1 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int n = 10;
        System.out.print(findMinCoinDenominationsToMakeChange(arr, n));
    }

    private static int findMinCoinDenominationsToMakeChange(int[] arr, int n) {
        if (n <= 0) return 0;
        if (arr == null) return 0;
        int[] tmp = new int[n + 1];
        tmp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            if (contains(arr, i)) {
                tmp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < arr.length; ++j) {
                    min = Math.min(min, 1 + findMinCoinDenominationsToMakeChange(arr, n - arr[j]));
                }
                tmp[i] = min;
            }
        }
        return tmp[n];
    }

    private static boolean contains(int[] arr, int i) {
        for (int c = 0; c < arr.length; ++c) {
            if (c == i)
                return true;
        }
        return false;
    }
}
