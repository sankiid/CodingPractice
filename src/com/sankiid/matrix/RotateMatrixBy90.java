package com.sankiid.matrix;

/**
 * Created by sandeep on 17/2/17.
 */
public class RotateMatrixBy90 {
	public static void main(String[] rags) {
		int mat[][] = { { 1, 2, 3, 4, 25 }, { 5, 6, 7, 8, 24 }, { 9, 10, 11, 12, 23 }, { 13, 14, 15, 16, 22 },
				{ 17, 18, 19, 20, 21 } };

		printMatrix(mat);
		rotate(mat);
		printMatrix(mat);

	}

	private static void rotate(int[][] mat) {
		int r = mat.length;
		int c = mat[0].length;
		for (int i = 0; i < r / 2; ++i) {
			for (int j = i; j < c - i - 1; ++j) {
				int tmp = mat[i][j];
				mat[i][j] = mat[j][c - 1 - i];
				mat[j][c - 1 - i] = mat[r - 1 - i][c - 1 - j];
				mat[r - 1 - i][c - 1 - j] = mat[r - 1 - j][i];
				mat[r - 1 - j][i] = tmp;
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
