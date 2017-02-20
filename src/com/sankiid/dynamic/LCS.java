package com.sankiid.dynamic;

/**
 * Created by sandeep on 20/2/17.
 * <p>
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of
 * length n has 2^n different possible subsequences.
 */
public class LCS {

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int max = getLongestCommonSubsequence(X, Y);
        System.out.print(max);
    }

    private static int getLongestCommonSubsequence(String x, String y) {
        int n = x.length();
        int m = y.length();
        int[][] tmp = new int[n][m];
        char yc = y.charAt(0);
        for (int i = 0; i < n; ++i) {
            tmp[i][0] = (i >= 1 && tmp[i - 1][0] == 1) || (yc == x.charAt(i)) ? 1 : 0;
        }
        char xc = x.charAt(0);
        for (int j = 0; j < n; ++j) {
            tmp[0][j] = (j >= 1 && tmp[0][j - 1] == 1) || (xc == y.charAt(j)) ? 1 : 0;
        }
        for (int i = 1; i < n; ++i) {
            xc = x.charAt(i);
            for (int j = 1; j < m; ++j) {
                if (xc == y.charAt(j)) {
                    tmp[i][j] = 1 + tmp[i - 1][j - 1];
                } else {
                    tmp[i][j] = Math.max(tmp[i - 1][j], tmp[i][j - 1]);
                }
            }
        }
        return tmp[n - 1][m - 1];
    }
}
