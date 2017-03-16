package com.sankiid.array;

/**
 * Created by sankiid on 11-03-2017.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] array = {
                1, 2, 3, 4, 5
        };
        int k = 5;
        rotateArray(array, k);
        for (int i : array) {
            System.out.printf("%d ", i);
        }
    }

    private static void rotateArray(int[] array, int k) {
        int n = array.length;
        k = k % n;
        reverse(array, 0, k - 1);
        reverse(array, k, n-1);
        reverse(array, 0, n-1);

    }

    private static void reverse(int[] array, int i, int j) {
        if (i < 0 || j >= array.length) return;
        int x = i, y = j;
        while (x < y) {
            int t = array[x];
            array[x] = array[y];
            array[y] = t;
            ++x;
            --y;
        }
    }

}
