package com.sankiid.string;

/**
 * Created by sandeep on 15/2/17.
 */
public class NaivePatternSearching {
    public static void main(String[] args) {
        String text = "AAAAAAAB";
        String pattern = "AAAB";
        int index = searchPattern(text, pattern);
        System.out.println(index >= 0 ? "found pattern at " + index : "pattern not found");
    }

    private static int searchPattern(String text, String pattern) {
        int index = -1;
        int n = text.length();
        int m = pattern.length();
        if (m > n) return index;

        for (int i = 0; i < (n - m) + 1; ++i) {
            int j = 0;
            while (j < m) {
                if (text.charAt(i + j) == pattern.charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }
            if (j == m) {
                index = i;
                break;
            }
        }
        return index;
    }
}
