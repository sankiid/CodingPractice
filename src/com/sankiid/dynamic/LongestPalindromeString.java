package com.sankiid.dynamic;

/**
 * Created by sankiid on 18-03-2017.
 */
public class LongestPalindromeString {
    public static void main(String[] args) {
        String s = "bananna";
        String p = logestPalindromeSubstring(s);
        System.out.println(p);
        String sp = logestPalindromeSubsquence(s);
        System.out.println(sp);
    }

    private static String logestPalindromeSubsquence(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return LCS.getLongestCommonSubsequence(s, t);
    }

    private static String logestPalindromeSubstring(String s) {
        if (s == null) return null;
        boolean[][] matrix = new boolean[s.length()][s.length()];
        int max = 1;
        int startIdx = 0;
        for (int i = 0; i < s.length(); ++i) {
            matrix[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                matrix[i][i + 1] = true;
                max = 2;
                startIdx = i;
            }
        }
        for (int n = 3; n <= s.length(); ++n) {
            for (int i = 0; i < s.length() - n + 1; ++i) {
                int j = i + n - 1;
                if (s.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1]) {
                    matrix[i][j] = true;
                    if (max < n) {
                        max = n;
                        startIdx = i;
                    }
                }
            }
        }
        return s.substring(startIdx, startIdx + max);
    }
}
