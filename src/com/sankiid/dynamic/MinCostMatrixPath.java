package com.sankiid.dynamic;

/**
 * Created by sankiid on 18-03-2017.
 */
public class MinCostMatrixPath {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 2, 8},
                {1, 9, 7},
                {0, 5, 2},
                {6, 4, 3}
        };

        System.out.println("Minimum cost: " + minimumCostPathDP(matrix, 3, 2));
    }

    private static int minimumCostPathDP(int[][] matrix, int m, int n) {
        int[][] cost = new int[m + 1][n + 1];
        cost[0][0] = matrix[0][0];
        for (int j = 1; j <= m; ++j) {
            cost[j][0] = cost[j - 1][0] + matrix[j][0];
        }
        for (int i = 1; i <= n; ++i) {
            cost[0][i] = cost[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int min = Math.min(cost[i - 1][j - 1], Math.min(cost[i - 1][j], cost[i][j - 1]));
                cost[i][j] = min + matrix[i][j];
            }
        }
        return cost[m][n];
    }
}
