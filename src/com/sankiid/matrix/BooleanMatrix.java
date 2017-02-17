package com.sankiid.matrix;

/**
 * Created by sandeep on 17/2/17.
 */
public class BooleanMatrix {
    public static void main(String[] args) {
        int mat[][] = {
                {1, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
        };

        printMatrix(mat);
        modify(mat);
        printMatrix(mat);
    }

    private static void modify(int[][] mat) {
        int[] row = new int[mat.length];
        int[] column = new int[mat[0].length];
        int i, j;
        for (i = 0; i < mat.length; i++) {
            for (j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    row[i] = column[j] = 1;
                }
            }
        }
        for (i = 0; i < mat.length; i++) {
            for (j = 0; j < mat[0].length; j++) {
                if (row[i] ==1 || column[j] == 1) {
                    mat[i][j] = 1;
                }
            }
        }

    }

    static void printMatrix(int mat[][]) {
        int i, j;
        for (i = 0; i < mat.length; i++) {
            for (j = 0; j < mat[0].length; j++) {
                System.out.printf("%d ", mat[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }
}
