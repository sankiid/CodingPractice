package com.sankiid.matrix;

/**
 * Created by sandeep on 17/2/17.
 */
public class SearchInRowColumnSorted {
    public static void main(String[] args) {
        int mat[][] = {
                {
                        10, 20, 30, 40
                },
                {
                        15, 25, 35, 45
                },
                {
                        27, 29, 37, 48
                },
                {
                        32, 33, 39, 50
                },
        };
        search(mat, 29);
    }

    private static void search(int[][] mat, int x) {
        int r = mat.length;
        int c = mat[0].length;
        int j = c - 1;
        int i = 0;
        boolean found = false;
        while (i < r && j >= 0) {
            if (mat[i][j] == x) {
                System.out.println(i + "," + j);
                found = true;
                break;
            } else if (mat[i][j] < x) {
                i++;
            } else {
                j--;
            }
        }
        if (!found)
            System.out.println("not found");
    }
}
