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
		int n = mat.length;
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - layer - 1;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				// save top
				int top = mat[first][i];
				// Left - Top
				mat[first][i] = mat[last - offset][first];
				// bootom - left
				mat[last - offset][first] = mat[last][last - offset];
				// right - bottom
				mat[last][last - offset] = mat[i][last];
				// top - right
				mat[i][last] = top;
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
