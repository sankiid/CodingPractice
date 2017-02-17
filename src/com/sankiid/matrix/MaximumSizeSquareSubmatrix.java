package com.sankiid.matrix;

/**
 * Created by sandeep on 17/2/17.
 */
public class MaximumSizeSquareSubmatrix {

    public static void main(String[] args) {
        int mat[][] = {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int subSquareMatsize = getSize(mat);
        System.out.printf("%d", subSquareMatsize);
    }

    private static int getSize(int[][] mat) {
        int max = 0;
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (mat[i][j] >= 1) {
                    mat[i][j] = Math.min(Math.min(mat[i - 1][j - 1], mat[i - 1][j]), mat[i][j - 1]) + 1;
                } else {
                    mat[i][j] = 0;
                }
                if (max < mat[i][j])
                    max = mat[i][j];
            }
        }
        if(max == 0){
            for (int i = 0; i < n; ++i) {
                if(mat[0][i] == 1){
                    max = 1;
                    break;
                }
            }
            for (int i = 0; i < m; ++i) {
                if(mat[i][0] == 1){
                    max = 1;
                    break;
                }
            }
        }
        return max;
    }

}
