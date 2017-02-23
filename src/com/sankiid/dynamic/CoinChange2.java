package com.sankiid.dynamic;

/**
 * Created by sandeep on 22/2/17.
 * <p>
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of
 * S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 */
public class CoinChange2 {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int c = count(arr, 4);
        System.out.print(c);
    }

    private static int count(int[] arr, int m) {
        int n = arr.length;
        return 0;
    }
}
