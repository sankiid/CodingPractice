package com.sankiid.array;

import java.util.Arrays;

/**
 * Created by sankiid on 11-03-2017.
 */
public class NextGreaterNumber {
    public static void main(String[] args) {
        int[] arr = {
                6, 9, 3, 8, 6, 5, 2
        };
        int[] n = findNextGreaterNumber(arr);
        for (int i : n) {
            System.out.print(i);
        }
    }

    public static int[] findNextGreaterNumber(int[] arr) {
        boolean found = false;
        int idx = -1;
        for (int i = arr.length - 1; i > 0; --i) {
            if (arr[i - 1] < arr[i]) {
                idx = i - 1;
                break;
            }
        }
        if (idx != -1) {
            int id = -1;
            for (int i = arr.length - 1; i >= idx; --i) {
                if (arr[i] > arr[idx]) {
                    int t = arr[i];
                    arr[i] = arr[idx];
                    arr[idx] = t;
                    break;
                }
            }
            Arrays.sort(arr, idx + 1, arr.length);
            return arr;
        }
        return null;
    }
}
