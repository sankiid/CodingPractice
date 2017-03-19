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
        String X = "DACA";
        String Y = "ACBEA";

        String longestSubsequence = getLongestCommonSubsequence(X, Y);
        System.out.println(longestSubsequence);
        System.out.println(longestCommonSubstring("LCLC", "CLCL"));
    }

    private static String longestCommonSubstring(String s1, String s2) {
        if (s1 == null || s2 == null) return null;
        if (s1.intern() == s2.intern()) return s1;

        int n = s1.length();
        int m = s2.length();
        int[][] tmp = new int[n][m];
        for (int j = 0; j < n; ++j) {
            tmp[0][j] = s1.charAt(j) == s2.charAt(0) ? 1 : 0;
        }
        for (int i = 0; i < m; ++i) {
            tmp[i][0] = s1.charAt(0) == s2.charAt(i) ? 1 : 0;
        }
        int max = 0;
        int endingIdx = -1;
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (s1.charAt(j) == s2.charAt(i)) {
                    tmp[i][j] = tmp[i - 1][j - 1] + 1;
                    if (max < tmp[i][j]) {
                        max = tmp[i][j];
                        endingIdx = i;
                    }
                } else {
                    tmp[i][j] = 0;
                }
            }
        }

        return s2.substring(endingIdx + 1 - max, endingIdx + 1);
    }

    public static String getLongestCommonSubsequence(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] tmp = new int[n][m];

        tmp[0][0] = y.charAt(0) == x.charAt(0) ? 1 : 0;
        for (int i = 1; i < m; ++i) {
            tmp[0][i] = (y.charAt(0) == x.charAt(i) || tmp[0][i - 1] == 1) ? 1 : 0;
        }
        for (int j = 1; j < n; ++j) {
            tmp[j][0] = (x.charAt(0) == y.charAt(j) || tmp[j - 1][0] == 1) ? 1 : 0;
        }

        for (int j = 1; j < n; ++j) {
            for (int i = 1; i < m; ++i) {
                if (x.charAt(i) == y.charAt(j)) {
                    tmp[j][i] = 1 + tmp[j - 1][i - 1];
                } else {
                    tmp[j][i] = Math.max(tmp[j - 1][i], tmp[j][i - 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        int i = n - 1, j = m - 1;
        while (i >= 0 && j >= 0) {
            if (x.charAt(j) == y.charAt(i)) {
                sb.insert(0, x.charAt(j));
                i--;
                j--;
            } else if (tmp[i][j] == tmp[i - 1][j]) {
                --i;
            } else {
                --j;
            }
        }
        return sb.toString();
    }
}
