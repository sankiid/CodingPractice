package com.sankiid.dynamic;

/**
 * Created by sankiid on 17-03-2017.
 */
public class PalindromePartition {
    public static void main(String[] args) {
        String s = "banana";
        int partitions = findPartitionNumber(s);
        System.out.print(partitions);
    }

    private static int findPartitionNumber(String s) {
        if (s == null) return 0;
        boolean[][] part = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            part[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                part[i][i + 1] = true;
            }
        }
        for (int n = 3; n <= s.length(); ++n) {
            for (int i = 0; i < s.length() - n + 1; ++i) {
                int j = i + n - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    part[i][j] = true;
                }
            }
        }

        int[] cuts = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {

        }
        return -1;
    }
}
