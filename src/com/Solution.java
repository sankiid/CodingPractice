
package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by sankiid on 05-03-2017.
 */
public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split("[ ]");
        int n = Integer.parseInt(token[0]);
        int m = Integer.parseInt(token[1]);

        int sum = 0;
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; ++i) {
            token = br.readLine().split("[ ]");
            for (int j = 0; j < n; ++j) {
                sum += Integer.parseInt(token[j]);
                mat[i][j] = 1;
            }
        }

        sum = sum - n * n;
        int ii = n - 1, jj = n - 1;
        int line = 2 * (n - 1);
        while (line >= 0 && sum > 0) {
            if (line % 2 == 0) {
                ii = line / 2;
                jj = line / 2;
                sum = getAndSetSum(m, sum, mat, ii, jj);
                ii++;
                jj--;
                sum = calculateSum(n, m, sum, mat, ii, jj, line);
            } else {
                ii = (line + 1) / 2;
                jj = line - ii;
                sum = calculateSum(n, m, sum, mat, ii, jj, line);
            }
            line--;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.printf("%d ", mat[i][j]);
            }
            System.out.println();
        }
    }

    private static int calculateSum(int n, int m, int sum, int[][] mat, int ii, int jj, int line) {
        while (sum > 0 && (ii < n && jj >= 0 && ii >= 0 && jj < n) && ii + jj == line) {
            sum = getAndSetSum(m, sum, mat, ii, jj);
            sum = getAndSetSum(m, sum, mat, jj, ii);
            ii++;
            jj--;
        }
        return sum;
    }

    private static int getAndSetSum(int m, int sum, int[][] mat, int ii, int jj) {
        if (sum <= 0) return 0;
        if (sum > m - 1) {
            mat[ii][jj] += m - 1;
            sum = sum - m + 1;
        } else {
            mat[ii][jj] += sum;
            sum = 0;
        }
        return sum;
    }
}
