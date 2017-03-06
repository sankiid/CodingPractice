package com.sankiid.graph2;

/**
 * Created by sankiid on 06-03-2017.
 * Number of clusters of 1s OR Number of Islands
 */
public class Clusters {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1},
        };
        int count = findNumberofClusters(matrix);
        System.out.println(count);
    }

    private static int findNumberofClusters(int[][] matrix) {
        if (matrix == null) return 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    count++;
                    int [] size = new int[1];
                    size[0] = 1;
                    dfs(matrix, visited, i, j, size);
                    if(size[0] > max){
                        max = size[0];
                    }
                }
            }
        }
        System.out.println("Max size island "+max);
        return count;
    }

    private static void dfs(int[][] matrix, boolean[][] visited, int i, int j, int [] size) {
        if (visited[i][j]) return;
        visited[i][j] = true;
        for (int l = (i - 1); l <= (i + 1); l++) {
            if (l < 0 || l >= matrix.length) continue;
            for (int k = (j - 1); k <= (j + 1); k++) {
                if (k < 0 || k >= matrix[0].length) continue;
                if (matrix[l][k] == 1 && !visited[l][k]) {
                    size[0]++;
                    dfs(matrix, visited, l, k, size);
                }
            }
        }
    }
}
