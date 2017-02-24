package com.sankiid.dynamic;

/**
 * Created by sandeep on 23/2/17.
 */
public class BinomialCoefficient {

    public static void main(String[] args) {
        int i = binomialCoeff(5, 4);
        System.out.print(i);
    }

    public static int binomialCoeff(int n, int k) {
        if (k == n || k == 0) return 1;
        int[][] tmp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                if (j > i) break;
                if (i == j || j == 0) {
                    tmp[i][j] = 1;
                } else {
                    tmp[i][j] = tmp[i - 1][j] + tmp[i - 1][j - 1];
                }
            }
        }
        return tmp[n][k];
    }
}
